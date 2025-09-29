package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.EventDto;
import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Event;

import java.util.List;

public interface IEventService {

    void saveEvent(EventDto eventDto);

    List<Event> getEvents();

    Event getEventById(Long idEvent);

    void editEvent(Long idEvent, EventDto eventDto);

    void deleteEventById(Long idEvent);

    void addImagesToEvent(Long idEvent, List<ImageDto> imagesDto);

    void deleteImagesFromEvent(Long idEvent, List<Long> imageIds);
}
