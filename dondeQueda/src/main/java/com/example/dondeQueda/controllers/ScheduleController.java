package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.ScheduleDto;
import com.example.dondeQueda.models.Schedule;
import com.example.dondeQueda.services.interfaces.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horario")
public class ScheduleController {

    @Autowired
    private IScheduleService scheduleService;

    @PostMapping("/guardar")
    public ResponseEntity<?> saveSchedule(@RequestBody ScheduleDto scheduleDto){
        scheduleService.saveSchedule(scheduleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Horario guardado correctamente.");
    }

    @GetMapping("/traer")
    public ResponseEntity<List<Schedule>> getSchedules(){
        return ResponseEntity.ok(scheduleService.getSchedules());
    }

    @GetMapping("/traer/{idSchedule}")
    public ResponseEntity<?> getScheduleById(@PathVariable Long idSchedule){
        return ResponseEntity.ok(scheduleService.getScheduleById(idSchedule));
    }

    @PutMapping("/editar/{idSchedule}")
    public ResponseEntity<?> editSchedule(@PathVariable Long idSchedule,
                               @RequestBody ScheduleDto scheduleDto){
        scheduleService.editSchedule(idSchedule, scheduleDto);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Horario editado correctamente.");
    }

    @DeleteMapping("/eliminar/{idSchedule}")
    public ResponseEntity<?> deleteScheduleById(@PathVariable Long idSchedule){

        scheduleService.deleteScheduleById(idSchedule);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Horario eliminado correctamente.");
    }
}
