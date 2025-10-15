package com.example.dondeQueda.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  @JsonIgnore
  private Event event;

  @OneToOne(mappedBy = "address")
  @JsonIgnore
  private Commerce commerce;

  public Address() {}

  public Address(
      Long idAddress,
      String address,
      String street,
      String district,
      String location,
      Event event,
      Commerce commerce) {
    this.idAddress = idAddress;
    this.address = address;
    this.street = street;
    this.district = district;
    this.location = location;
    this.event = event;
    this.commerce = commerce;
  }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public void setCommerce(Commerce commerce) {
        this.commerce = commerce;
    }
}
