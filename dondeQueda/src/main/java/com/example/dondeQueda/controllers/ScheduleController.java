package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.ScheduleDto;
import com.example.dondeQueda.models.Schedule;
import com.example.dondeQueda.services.interfaces.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horario")
public class ScheduleController {

    @Autowired
    private IScheduleService scheduleService;

    @PostMapping("/guardar")
    public String saveSchedule(@RequestBody ScheduleDto scheduleDto){
        return scheduleService.saveSchedule(scheduleDto);
    }

    @GetMapping("/traer")
    public List<Schedule> getSchedules(){
        return scheduleService.getSchedules();
    }

    @GetMapping("/traer/{idSchedule}")
    public Schedule getScheduleById(@PathVariable Long idSchedule){
        return scheduleService.getScheduleById(idSchedule);
    }

    @PutMapping("/editar/{idSchedule}")
    public String editSchedule(@PathVariable Long idSchedule,
                               @RequestBody ScheduleDto scheduleDto){
        return scheduleService.editSchedule(idSchedule, scheduleDto);
    }

    @DeleteMapping("/eliminar/{idSchedule}")
    public String deleteScheduleById(@PathVariable Long idSchedule){
        return scheduleService.deleteScheduleById(idSchedule);
    }
}
