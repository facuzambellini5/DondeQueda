package com.example.dondeQueda.models;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    private String address;

    private String street;

    private String district;

    private String location;

    @OneToOne(mappedBy = "address")
    private Event event;

    @OneToOne(mappedBy = "address")
    private Commerce commerce;
}
