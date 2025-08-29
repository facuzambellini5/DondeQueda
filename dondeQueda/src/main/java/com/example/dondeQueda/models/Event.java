package com.example.dondeQueda.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    private String title;

    private String description;

    private int capacity;

    //RELACION CON ADDRESS

}
