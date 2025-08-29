package com.example.dondeQueda.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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


}
