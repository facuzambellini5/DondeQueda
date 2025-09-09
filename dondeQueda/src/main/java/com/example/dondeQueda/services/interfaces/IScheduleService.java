package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.ScheduleDto;
import com.example.dondeQueda.models.Schedule;

import java.util.List;

public interface IScheduleService {

  String saveSchedule(ScheduleDto scheduleDto);

  List<Schedule> getSchedules();

  Schedule getScheduleById(Long idSchedule);

  String editSchedule(Long idSchedule, ScheduleDto scheduleDto);

  String deleteScheduleById(Long idSchedule);
}
