package com.example.dondeQueda.dtos;

import java.math.BigDecimal;

public class SubscriptionDto {

    private String nameSubscription;

    private BigDecimal price;

    private int duration;

    private String description;

    private int maxCommerces;

    private int maxPosts;

    public String getNameSubscription() {
        return nameSubscription;
    }

    public void setNameSubscription(String nameSubscription) {
        this.nameSubscription = nameSubscription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxCommerces() {
        return maxCommerces;
    }

    public void setMaxCommerces(int maxCommerces) {
        this.maxCommerces = maxCommerces;
    }

    public int getMaxPosts() {
        return maxPosts;
    }

    public void setMaxPosts(int maxPosts) {
        this.maxPosts = maxPosts;
    }
}
