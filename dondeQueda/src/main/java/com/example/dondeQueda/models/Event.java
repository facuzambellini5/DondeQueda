package com.example.dondeQueda.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at")
    @UpdateTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @ManyToMany(mappedBy = "events")
    @JsonIgnore
    private List<Commerce> commerces = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private List<Image> images = new ArrayList<>();

    public Event() {
    }

    public Event(Long idEvent, LocalDateTime startDate, LocalDateTime endDate, String title, String description, boolean isActive, LocalDateTime createdAt, Address address, List<Commerce> commerces, List<Image> images) {
        this.idEvent = idEvent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.createdAt = createdAt;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
