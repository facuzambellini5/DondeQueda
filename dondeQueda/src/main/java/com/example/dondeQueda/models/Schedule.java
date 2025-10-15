package com.example.dondeQueda.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSchedule;

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

    @ManyToOne
    @JoinColumn(name = "id_commerce")
    @JsonIgnore
    private Commerce commerce;

    public Schedule() {
    }

    public Schedule(Long idSchedule, DayOfWeek day, LocalTime morningOpening, LocalTime morningClosing, LocalTime afternoonOpening, LocalTime afternoonClosing, boolean isContinuous, Commerce commerce) {
        this.idSchedule = idSchedule;
        this.day = day;
        this.morningOpening = morningOpening;
        this.morningClosing = morningClosing;
        this.afternoonOpening = afternoonOpening;
        this.afternoonClosing = afternoonClosing;
        this.isContinuous = isContinuous;
        this.commerce = commerce;
    }

    public Long getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getMorningOpening() {
        return morningOpening;
    }

    public void setMorningOpening(LocalTime morningOpening) {
        this.morningOpening = morningOpening;
    }

    public LocalTime getMorningClosing() {
        return morningClosing;
    }

    public void setMorningClosing(LocalTime morningClosing) {
        this.morningClosing = morningClosing;
    }

    public LocalTime getAfternoonOpening() {
        return afternoonOpening;
    }

    public void setAfternoonOpening(LocalTime afternoonOpening) {
        this.afternoonOpening = afternoonOpening;
    }

    public LocalTime getAfternoonClosing() {
        return afternoonClosing;
    }

    public void setAfternoonClosing(LocalTime afternoonClosing) {
        this.afternoonClosing = afternoonClosing;
    }

    public boolean isContinuous() {
        return isContinuous;
    }

    public void setContinuous(boolean continuous) {
        isContinuous = continuous;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public void setCommerce(Commerce commerce) {
        this.commerce = commerce;
    }
}
