package com.example.dondeQueda.dtos;

import java.time.LocalDateTime;

public class EventDto {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String title;
    private String description;
    private boolean isActive;

    public EventDto() {
    }

    public EventDto(LocalDateTime startDate, LocalDateTime endDate, String title, String description, boolean isActive) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
        this.isActive = isActive;
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
}
