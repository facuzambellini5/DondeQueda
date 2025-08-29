package com.example.dondeQueda.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubscription;

    @Column(name = "name_subscription")
    private String nameSubscription;

    private double price;

    private int duration;

    private String description;

    @Column(name = "max_commerces")
    private int maxCommerces;

    @Column(name = "max_posts")
    private int maxPosts;

    @OneToMany(mappedBy = "subscription")
    private List<User> users;

}
