package com.example.dondeQueda.models;

import com.example.dondeQueda.enums.CommerceType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Commerce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommerce;

    private String name;

    private String description;

    private String phone;

    private String link;

    @Column(name = "commerce_type")
    @Enumerated(EnumType.STRING)
    private CommerceType commerceType;

    private String email;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "branch_of")
    private Commerce branchOf;

    @OneToMany(mappedBy = "branchOf")
    private List<Commerce> commerces;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User owner;

    @OneToMany(mappedBy = "commerce")
    private List<Post> posts;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToMany(mappedBy = "commerce")
    private List<Schedule> schedules;

    @ManyToMany
    @JoinTable(
            name = "commerce_category",
            joinColumns = @JoinColumn(name = "id_commerce"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "event_commerce",
            joinColumns = @JoinColumn(name = "id_commerce"),
            inverseJoinColumns = @JoinColumn(name = "id_event")
    )
    private List<Event> events;

    @ManyToMany
    @JoinTable(
            name = "commerce_tag",
            joinColumns = @JoinColumn(name = "id_commerce"),
            inverseJoinColumns = @JoinColumn(name = "id_tag")
    )
    private List<Tag> tags;

    @ManyToMany
    @JoinTable(
            name = "commerce_image",
            joinColumns = @JoinColumn(name = "id_commerce"),
            inverseJoinColumns = @JoinColumn(name = "id_image")
    )
    private List<Image> images;
}
