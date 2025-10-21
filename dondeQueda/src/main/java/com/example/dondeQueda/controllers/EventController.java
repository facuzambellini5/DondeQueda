package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.EventDto;
import com.example.dondeQueda.services.interfaces.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventController {

    @Autowired
    private IEventService eventService;

    @PostMapping("/guardar")
    ResponseEntity<?> saveEvent(@RequestBody EventDto eventDto,
                                @RequestParam List<MultipartFile> images) throws IOException {
        eventService.saveEvent(eventDto, images);
        return ResponseEntity.status(HttpStatus.CREATED).body("Evento creado correctamente.");
    }

    @GetMapping("/traer")
    ResponseEntity<?> getEvents(){
        return ResponseEntity.ok(eventService.getEvents());
    }

    @GetMapping("/traer/{idEvent}")
    ResponseEntity<?> getEventById(@PathVariable Long idEvent){
        return ResponseEntity.ok(eventService.getEventById(idEvent));
    }

    @PutMapping("/editar/{idEvent}")
    ResponseEntity<?> editEvent(@PathVariable Long idEvent,
                                @RequestBody EventDto eventDto){
        eventService.editEvent(idEvent, eventDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Evento editado correctamente.");
    }

    @DeleteMapping("/eliminar/{idEvent}")
    ResponseEntity<?> deleteEventById(@PathVariable Long idEvent){
        eventService.deleteEventById(idEvent);
        return ResponseEntity.ok("Evento eliminado correctamente.");
    }

    @PostMapping("/agregar/imagenes/{idEvent}")
    ResponseEntity<?> addImagesToEvent(@PathVariable Long idEvent,
                                       @RequestParam List<MultipartFile> images) throws IOException {
        eventService.addImagesToEvent(idEvent, images);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Imagen/es añadidas correctamente.");
    }

    @PostMapping("/eliminar/imagenes/{idEvent}")
    ResponseEntity<?> deleteImagesFromEvent(@PathVariable Long idEvent,
                                            @RequestParam List<Long> eventIds){
        eventService.deleteImagesFromEvent(idEvent, eventIds);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Imagen/es eliminadas correctamente.");

    }

}
