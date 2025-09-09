package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.EventDto;
import com.example.dondeQueda.models.Address;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.repositories.IAddressRepository;
import com.example.dondeQueda.repositories.ICommerceRepository;
import com.example.dondeQueda.repositories.IEventRepository;
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


    @Override
    public String saveEvent(EventDto eventDto) {

        Event event = new Event();
        Address address = validatorService.validateAddress(eventDto.getIdAddress());

        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setCapacity(eventDto.getCapacity());

    }

    @Override
    public List<Event> getEvents() {
        return List.of();
    }

    @Override
    public Event getEventById(Long idEvent) {
        return null;
    }

    @Override
    public String editEvent(Long idEvent, EventDto eventDto) {
        return "";
    }

    @Override
    public String deleteEventById(Long idEvent) {
        return "";
    }
}
