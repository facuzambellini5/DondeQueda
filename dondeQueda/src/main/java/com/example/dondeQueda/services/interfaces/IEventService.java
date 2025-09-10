package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.EventDto;
import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Image;

import java.util.List;

public interface IEventService {

    String saveEvent(EventDto eventDto);

    List<Event> getEvents();

    Event getEventById(Long idEvent);

    String editEvent(Long idEvent, EventDto eventDto);

    String deleteEventById(Long idEvent);

    String addImagesToEvent(Long idEvent, List<ImageDto> imagesDto);

    String deleteImagesToEvent(Long idEvent, List<Long> imageIds);
}
