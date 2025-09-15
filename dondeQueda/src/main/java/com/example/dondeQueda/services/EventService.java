package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.EventDto;
import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Address;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.repositories.IAddressRepository;
import com.example.dondeQueda.repositories.ICommerceRepository;
import com.example.dondeQueda.repositories.IEventRepository;
import com.example.dondeQueda.repositories.IImageRepository;
import com.example.dondeQueda.services.interfaces.IEventService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventService implements IEventService {

    @Autowired
    private IEventRepository eventRepo;
    @Autowired
    private ICommerceRepository commerceRepo;
    @Autowired
    private IAddressRepository addressRepo;
    @Autowired
    private EntityValidatorService validatorService;
    @Autowired
    private IImageRepository imageRepo;


    @Override
    public String saveEvent(EventDto eventDto) {

        Event event = new Event();
        Address address = validatorService.validateAddress(eventDto.getIdAddress());
        Commerce commerce = validatorService.validateCommerce(eventDto.getIdCommerce());

        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setCapacity(eventDto.getCapacity());
        event.setAddress(address);
        event.getCommerces().add(commerce);

        commerce.getEvents().add(event);

        eventRepo.save(event);
        commerceRepo.save(commerce);

        return "Evento guardado correctamente.";
    }

    @Override
    public List<Event> getEvents() {
        return eventRepo.findAll();
    }

    @Override
    public Event getEventById(Long idEvent) {
        return validatorService.validateEvent(idEvent);
    }

    @Override
    public String editEvent(Long idEvent, EventDto eventDto) {

        Event event = validatorService.validateEvent(idEvent);

        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setCapacity(eventDto.getCapacity());

        eventRepo.save(event);

        return "Evento editado correctamente.";
    }

    @Override
    public String deleteEventById(Long idEvent) {

        Event event = validatorService.validateEvent(idEvent);
        eventRepo.delete(event);

        return "Evento eliminado correctamente.";
    }

    @Override
    public String addImagesToEvent(Long idEvent, List<ImageDto> imagesDto) {

        Event event = validatorService.validateEvent(idEvent);

        for(ImageDto imageDto : imagesDto){

            Image image = new Image();

            image.setUrl(imageDto.getUrl());
            image.setType(imageDto.getType());

            imageRepo.save(image);

            event.getImages().add(image);
        }
        eventRepo.save(event);

        return "Imagen/es agregadas correctamente.";
    }

    @Override
    public String deleteImagesToEvent(Long idEvent, List<Long> imageIds) {

        Event event = validatorService.validateEvent(idEvent);


        return "Imagen/es eliminadas correctamente.";
    }

}

