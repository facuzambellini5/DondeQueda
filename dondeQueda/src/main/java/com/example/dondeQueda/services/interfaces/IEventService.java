package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.EventDto;
import com.example.dondeQueda.dtos.EventResponseDto;
import com.example.dondeQueda.models.Event;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IEventService {

    void saveEvent(EventDto eventDto, List<MultipartFile> images) throws IOException;

    List<EventResponseDto> getEvents();

    Event getEventById(Long idEvent);

    EventResponseDto getEventResponseById(Long idEvent);

    void editEvent(Long idEvent, EventDto eventDto);

    void deleteEventById(Long idEvent);

    void addImagesToEvent(Long idEvent, List<MultipartFile> images) throws IOException;

    void deleteImagesFromEvent(Long idEvent, List<Long> imageIds);
}
