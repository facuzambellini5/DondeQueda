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

  @Autowired private IScheduleRepository scheduleRepo;
  @Autowired private ICommerceRepository commerceRepo;

  @Override
  public void saveSchedule(ScheduleDto scheduleDto, Commerce commerce) {

    Schedule schedule = new Schedule();

    schedule.setDay(scheduleDto.getDay());
    schedule.setMorningOpening(scheduleDto.getMorningOpening());
    schedule.setMorningClosing(scheduleDto.getMorningClosing());
    schedule.setAfternoonOpening(scheduleDto.getAfternoonOpening());
    schedule.setAfternoonClosing(scheduleDto.getAfternoonClosing());
    schedule.setContinuous(scheduleDto.isContinuous());
    schedule.setCommerce(commerce);

    //TODO implementar lógica de si es de corrido (ver si es necesario)

    commerce.getSchedules().add(schedule);

    scheduleRepo.save(schedule);
    commerceRepo.save(commerce); // TODO VER IMPLEMENTACIÓN DE CASCADE
  }

  @Override
  public void saveSchedules(List<ScheduleDto> scheduleDtos) {

    Commerce commerce =
        ValidationUtils.validateEntity(
            commerceRepo.findById(scheduleDtos.getFirst().getIdCommerce()),
            "Commerce",
            scheduleDtos.getFirst().getIdCommerce());

    for (ScheduleDto scheduleDto : scheduleDtos) {
      this.saveSchedule(scheduleDto, commerce);
    }
  }

  @Override
  public List<Schedule> getSchedules() {
    return scheduleRepo.findAll();
  }

  @Override
  public List<Schedule> getSchedulesByCommerce(Long idCommerce) {
    Commerce commerce =
        ValidationUtils.validateEntity(commerceRepo.findById(idCommerce), "Comercio", idCommerce);
    return scheduleRepo.findByCommerce(commerce);
  }

  @Override
  public Schedule getScheduleById(Long idSchedule) {
    return ValidationUtils.validateEntity(scheduleRepo.findById(idSchedule), "Horario", idSchedule);
  }

  @Override
  public void editSchedule(Long idSchedule, ScheduleDto scheduleDto) {

    Schedule schedule = this.getScheduleById(idSchedule);

    if (scheduleDto.getDay() != null) {
      schedule.setDay(scheduleDto.getDay());
    }
    if (scheduleDto.getMorningOpening() != null){
      schedule.setMorningOpening(scheduleDto.getMorningOpening());
    }
    if (scheduleDto.getMorningClosing() != null) {
      schedule.setMorningClosing(scheduleDto.getMorningClosing());
    }
    if (scheduleDto.getAfternoonOpening() != null) {
      schedule.setAfternoonOpening(scheduleDto.getAfternoonOpening());
    }
    if (scheduleDto.getAfternoonClosing() != null) {
      schedule.setAfternoonClosing(scheduleDto.getAfternoonClosing());
    }

    schedule.setContinuous(scheduleDto.isContinuous());
  }

  @Override
  public void deleteScheduleById(Long idSchedule) {

    Schedule schedule = this.getScheduleById(idSchedule);
    scheduleRepo.delete(schedule);
  }
}
