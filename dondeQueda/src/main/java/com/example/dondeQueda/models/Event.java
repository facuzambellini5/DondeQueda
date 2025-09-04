package com.example.dondeQueda.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @ManyToMany(mappedBy = "events")
    private List<Commerce> commerces;

    @ManyToMany
    @JoinTable(
            name = "event_image",
            joinColumns = @JoinColumn(name = "id_event"),
            inverseJoinColumns = @JoinColumn(name = "id_image")
    )
    private List<Image> images;
}
