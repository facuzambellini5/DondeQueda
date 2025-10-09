package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.EventDto;
import com.example.dondeQueda.models.Address;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
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
    event.setCapacity(eventDto.getCapacity());
    event.getCommerces().add(commerce);

    for(MultipartFile image : images){
      imageService.uploadImageToEvent(event.getIdEvent(), image);
    }

    //TODO ver CASCADE
    commerce.getEvents().add(event);

    eventRepo.save(event);
    commerceService.saveCommerce(commerce);
  }

  @Override
  public List<Event> getEvents() {
    return eventRepo.findAll();
  }

  @Override
  public Event getEventById(Long idEvent) {
    return ValidationUtils.validateEntity(eventRepo.findById(idEvent),"Evento", idEvent);
  }

  @Override
  public void editEvent(Long idEvent, EventDto eventDto) {

    Event event = this.getEventById(idEvent);

    event.setStartDate(eventDto.getStartDate());
    event.setEndDate(eventDto.getEndDate());
    event.setTitle(eventDto.getTitle());
    event.setDescription(eventDto.getDescription());
    event.setCapacity(eventDto.getCapacity());

    eventRepo.save(event);
  }

  @Override
  public void deleteEventById(Long idEvent) {
    Event event = this.getEventById(idEvent);
    eventRepo.delete(event);
  }

  @Override
  public void addImagesToEvent(Long idEvent, List<MultipartFile> images) throws IOException {

    Event event = this.getEventById(idEvent);

    for (MultipartFile image : images) {
      imageService.uploadImageToEvent(event.getIdEvent(), image);
    }

    eventRepo.save(event);
  }

  @Override
  public void deleteImagesFromEvent(Long idEvent, List<Long> imageIds) {

    Event event = this.getEventById(idEvent);

    for (Long imageId : imageIds) {
      imageService.deleteImage(imageId);
    }

    eventRepo.save(event);
  }
}
