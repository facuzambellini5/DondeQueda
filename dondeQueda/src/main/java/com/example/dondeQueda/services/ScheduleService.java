package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.ScheduleDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Schedule;
import com.example.dondeQueda.repositories.ICommerceRepository;
import com.example.dondeQueda.repositories.IScheduleRepository;
import com.example.dondeQueda.services.interfaces.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService implements IScheduleService {

    @Autowired
    private IScheduleRepository scheduleRepo;
    @Autowired
    private ICommerceRepository commerceRepo;
    @Autowired
    private IEntityValidatorService  validatorService;

    @Override
    public String saveSchedule(ScheduleDto scheduleDto) {

        Schedule schedule = new Schedule();
        Commerce commerce = validatorService.validateCommerce(scheduleDto.getIdCommerce());

        schedule.setDay(scheduleDto.getDay());
        schedule.setMorningOpening(scheduleDto.getMorningOpening());
        schedule.setMorningClosing(scheduleDto.getMorningClosing());
        schedule.setAfternoonOpening(scheduleDto.getAfternoonOpening());
        schedule.setAfternoonClosing(scheduleDto.getAfternoonClosing());
        schedule.setContinuous(scheduleDto.isContinuous());
        schedule.setCommerce(commerce);

        commerce.getSchedules().add(schedule);

        scheduleRepo.save(schedule);
        commerceRepo.save(commerce);

        return "Horario guardado correctamente.";
    }

    @Override
    public List<Schedule> getSchedules() {
        return scheduleRepo.findAll();
    }

    @Override
    public Schedule getScheduleById(Long idSchedule) {
        return validatorService.validateSchedule(idSchedule);
    }

    @Override
    public String editSchedule(Long idSchedule, ScheduleDto scheduleDto) {

        Schedule schedule = validatorService.validateSchedule(idSchedule);

        schedule.setDay(scheduleDto.getDay());
        schedule.setMorningOpening(scheduleDto.getMorningOpening());
        schedule.setMorningClosing(scheduleDto.getMorningClosing());
        schedule.setAfternoonOpening(scheduleDto.getAfternoonOpening());
        schedule.setAfternoonClosing(scheduleDto.getAfternoonClosing());
        schedule.setContinuous(scheduleDto.isContinuous());

        return "Horario editado correctamente.";
    }

    @Override
    public String deleteScheduleById(Long idSchedule) {

        Schedule schedule = validatorService.validateSchedule(idSchedule);
        scheduleRepo.delete(schedule);

        return "Horario eliminado con éxito.";
    }
}
