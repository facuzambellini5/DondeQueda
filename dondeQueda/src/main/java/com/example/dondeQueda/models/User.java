package com.example.dondeQueda.models;

import com.example.dondeQueda.enums.UserRole;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String username;

    private String name;

    private String lastname;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String email;

    @Column(name = "recovery_email")
    private String recoveryEmail;

    private String phone;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "id_subscription")
    private Subscription subscription;

    @OneToMany(mappedBy = "owner")
    private List<Commerce> ownedCommerces;

    @ManyToMany
    @JoinTable(
            name = "saved",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_post")
    )
    private List<Post> savedPosts;

    @ManyToMany
    @JoinTable(
            name = "favorites",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_commerce")
    )
    private List<Commerce> favoriteCommerces;

}
