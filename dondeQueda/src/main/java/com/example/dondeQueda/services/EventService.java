package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.EventDto;
import com.example.dondeQueda.dtos.EventResponseDto;
import com.example.dondeQueda.models.Address;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.repositories.IEventRepository;
import com.example.dondeQueda.services.interfaces.IAddressService;
import com.example.dondeQueda.services.interfaces.ICommerceService;
import com.example.dondeQueda.services.interfaces.IEventService;
import com.example.dondeQueda.services.interfaces.IImageService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService implements IEventService {

  @Autowired private IEventRepository eventRepo;
  @Autowired private ICommerceService commerceService;
  @Autowired private IAddressService addressService;
  @Autowired
  private IImageService imageService;

  @Override
  public void saveEvent(EventDto eventDto, List<MultipartFile> images) throws IOException {

    //TODO VER si hacer validación de que tenga ALMENOS UNA imagen

    Event event = new Event();

    if (eventDto.getIdAddress() != null) {
      Address address = addressService.getAddressById(eventDto.getIdAddress());
        event.setAddress(address);
    }

    Commerce commerce = commerceService.getCommerceById(eventDto.getIdCommerce());

    event.setStartDate(eventDto.getStartDate());
    event.setEndDate(eventDto.getEndDate());
    event.setTitle(eventDto.getTitle());
    event.setDescription(eventDto.getDescription());
    event.getCommerces().add(commerce);

    for(MultipartFile image : images){
      this.addImagesToEvent(event.getIdEvent(), images);
    }

    //TODO ver CASCADE
    commerce.getEvents().add(event);

    eventRepo.save(event);
    commerceService.saveCommerce(commerce);
  }

  @Override
  public List<EventResponseDto> getEvents() {

    List<Event> events = eventRepo.findAll();
    List<EventResponseDto> eventResponseDtos = new ArrayList<>();

    for(Event event : events){
      EventResponseDto eventResponseDto = new EventResponseDto(event);
      eventResponseDtos.add(eventResponseDto);
    }
    return eventResponseDtos;
  }

  @Override
  public Event getEventById(Long idEvent) {
    return ValidationUtils.validateEntity(eventRepo.findById(idEvent),"Evento", idEvent);
  }

  @Override
  public EventResponseDto getEventResponseById(Long idEvent) {
    Event event = this.getEventById(idEvent);

    return new EventResponseDto(event);
  }

  @Override
  public void editEvent(Long idEvent, EventDto eventDto) {

    Event event = this.getEventById(idEvent);

    if(eventDto.getStartDate() != null) {
      event.setStartDate(eventDto.getStartDate());
    }
    if(eventDto.getEndDate() != null) {
      event.setEndDate(eventDto.getEndDate());
    }
    if(eventDto.getTitle() != null) {
      event.setTitle(eventDto.getTitle());
    }
    if(eventDto.getDescription() != null) {
      event.setDescription(eventDto.getDescription());
    }

    eventRepo.save(event);
  }

  @Override
  public void deleteEventById(Long idEvent) {
    Event event = this.getEventById(idEvent);

    for(Image image : event.getImages()){
      imageService.deleteImage(image.getIdImage());
    }

    eventRepo.delete(event);
  }

  @Override
  public void addImagesToEvent(Long idEvent, List<MultipartFile> images) throws IOException {

    int imageOrder = 1;

    for (MultipartFile image : images) {
      imageService.uploadImageToEvent(idEvent, imageOrder, image);
      imageOrder += 1;
    }
  }

  @Override
  public void deleteImagesFromEvent(Long idEvent, List<Long> imageIds) {
    for (Long imageId : imageIds) {
      imageService.deleteImage(imageId);
    }
  }
}
