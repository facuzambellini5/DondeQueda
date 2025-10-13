package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.ScheduleDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Schedule;

import java.util.List;

public interface IScheduleService {

  void saveSchedule(ScheduleDto scheduleDto, Commerce commerce);

  void saveSchedules(List<ScheduleDto> scheduleDtos);

  List<Schedule> getSchedules();

  List<Schedule> getSchedulesByCommerce(Long idCommerce);

  Schedule getScheduleById(Long idSchedule);

  void editSchedule(Long idSchedule, ScheduleDto scheduleDto);

  void deleteScheduleById(Long idSchedule);
}
