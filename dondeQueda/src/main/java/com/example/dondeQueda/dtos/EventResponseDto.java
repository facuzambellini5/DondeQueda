package com.example.dondeQueda.dtos;

import com.example.dondeQueda.models.Address;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Image;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventResponseDto {

    private Long idEvent;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String title;
    private String description;
    private boolean isActive;
    private Address address;
    private List<Commerce> commerces;
    private List<ImageDto> images = new ArrayList<>();

    public EventResponseDto() {
    }

    public EventResponseDto(Event event) {
        this.idEvent = event.getIdEvent();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.isActive = event.isActive();
        this.address = event.getAddress();
        this.commerces = event.getCommerces();

        for(Image image : event.getImages()){
            ImageDto imageDto = new ImageDto(image);
            this.images.add(imageDto);
        }
        this.images.sort(Comparator.comparing(ImageDto::getImageOrder));
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

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }
}
