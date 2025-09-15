package com.example.dondeQueda.models;

import com.example.dondeQueda.enums.EntityType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event implements ImageOwner {

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

    @Transient
    private List<Image> images;

    public Event() {
    }

    public Event(Long idEvent, LocalDateTime startDate, LocalDateTime endDate, String title, String description, int capacity, Address address, List<Commerce> commerces, List<Image> images) {
        this.idEvent = idEvent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.address = address;
        this.commerces = commerces;
        this.images = images;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Commerce> getCommerces() {
        return commerces;
    }

    public void setCommerces(List<Commerce> commerces) {
        this.commerces = commerces;
    }

    @Override
    public String getEntityType() {
    return EntityType.EVENT.name();
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
