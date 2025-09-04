package com.example.dondeQueda.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    private String title;

    private String description;

    @Column(name = "posted_at")
    private LocalDateTime postedAt;

    @ManyToOne
    @JoinColumn(name = "id_commerce")
    private Commerce commerce;

    @ManyToMany(mappedBy = "posts")
    private List<User> users;

    @ManyToMany
    @JoinTable(
            name = "post_image",
            joinColumns = @JoinColumn(name = "id_post"),
            inverseJoinColumns = @JoinColumn(name = "id_image")
    )
    private List<Image> images;


}
