package com.example.dondeQueda.models;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idShedule;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    @Column(name = "morning_opening")
    private LocalTime morningOpening;

    @Column(name = "morning_closing")
    private LocalTime morningClosing;

    @Column(name = "afternoon_opening")
    private LocalTime afternoonOpening;

    @Column(name = "afternoon_closing")
    private LocalTime afternoonClosing;

    @Column(name = "is_continuous")
    private boolean isContinuous;







}
