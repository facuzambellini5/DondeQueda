package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.ScheduleDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Schedule;
import com.example.dondeQueda.repositories.ICommerceRepository;
import com.example.dondeQueda.repositories.IScheduleRepository;
import com.example.dondeQueda.services.interfaces.ICommerceService;
import com.example.dondeQueda.services.interfaces.IScheduleService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService implements IScheduleService {

    @Autowired
    private IScheduleRepository scheduleRepo;
    @Autowired
    private ICommerceService commerceService;


    @Override
    public void saveSchedule(ScheduleDto scheduleDto) {

        Schedule schedule = new Schedule();
        Commerce commerce = commerceService.getCommerceById(scheduleDto.getIdCommerce());

        schedule.setDay(scheduleDto.getDay());
        schedule.setMorningOpening(scheduleDto.getMorningOpening());
        schedule.setMorningClosing(scheduleDto.getMorningClosing());
        schedule.setAfternoonOpening(scheduleDto.getAfternoonOpening());
        schedule.setAfternoonClosing(scheduleDto.getAfternoonClosing());
        schedule.setContinuous(scheduleDto.isContinuous());
        schedule.setCommerce(commerce);

        commerce.getSchedules().add(schedule);

        scheduleRepo.save(schedule);
        //commerceRepo.save(commerce); VER IMPLEMENTACIÓN DE CASCADE
    }

    @Override
    public List<Schedule> getSchedules() {
        return scheduleRepo.findAll();
    }

    @Override
    public Schedule getScheduleById(Long idSchedule) {
        return ValidationUtils.validateEntity(scheduleRepo.findById(idSchedule),"Horario",idSchedule);
    }

    @Override
    public void editSchedule(Long idSchedule, ScheduleDto scheduleDto) {

        Schedule schedule = this.getScheduleById(idSchedule);

        schedule.setDay(scheduleDto.getDay());
        schedule.setMorningOpening(scheduleDto.getMorningOpening());
        schedule.setMorningClosing(scheduleDto.getMorningClosing());
        schedule.setAfternoonOpening(scheduleDto.getAfternoonOpening());
        schedule.setAfternoonClosing(scheduleDto.getAfternoonClosing());
        schedule.setContinuous(scheduleDto.isContinuous());
    }

    @Override
    public void deleteScheduleById(Long idSchedule) {

        Schedule schedule = this.getScheduleById(idSchedule);
        scheduleRepo.delete(schedule);
    }
}
