package com.example.dondeQueda.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubscription;

    @Column(name = "name_subscription")
    private String nameSubscription;

    private BigDecimal price;

    private int duration;

    private String description;

    @Column(name = "max_commerces")
    private int maxCommerces;

    @Column(name = "max_posts")
    private int maxPosts;

    @OneToMany(mappedBy = "subscription")
    private List<User> users;

    public Subscription() {
    }

    public Subscription(Long idSubscription, String nameSubscription, BigDecimal price, int duration, String description, int maxCommerces, int maxPosts, List<User> users) {
        this.idSubscription = idSubscription;
        this.nameSubscription = nameSubscription;
        this.price = price;
        this.duration = duration;
        this.description = description;
        this.maxCommerces = maxCommerces;
        this.maxPosts = maxPosts;
        this.users = users;
    }

    public Long getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Long idSubscription) {
        this.idSubscription = idSubscription;
    }

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
