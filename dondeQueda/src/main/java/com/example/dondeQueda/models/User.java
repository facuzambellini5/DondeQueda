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

    @Column(name = "salt_password")
    private String saltPassword;

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

    public User() {
    }

    public User(Long idUser, String username, String name, String lastname, String password, String saltPassword, UserRole role, String email, String recoveryEmail, String phone, LocalDateTime createdAt, Subscription subscription, List<Commerce> ownedCommerces, List<Post> savedPosts, List<Commerce> favoriteCommerces) {
        this.idUser = idUser;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.saltPassword = saltPassword;
        this.role = role;
        this.email = email;
        this.recoveryEmail = recoveryEmail;
        this.phone = phone;
        this.createdAt = createdAt;
        this.subscription = subscription;
        this.ownedCommerces = ownedCommerces;
        this.savedPosts = savedPosts;
        this.favoriteCommerces = favoriteCommerces;
    }

    public String getSaltPassword() {
        return saltPassword;
    }

    public void setSaltPassword(String saltPassword) {
        this.saltPassword = saltPassword;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecoveryEmail() {
        return recoveryEmail;
    }

    public void setRecoveryEmail(String recoveryEmail) {
        this.recoveryEmail = recoveryEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public List<Commerce> getOwnedCommerces() {
        return ownedCommerces;
    }

    public void setOwnedCommerces(List<Commerce> ownedCommerces) {
        this.ownedCommerces = ownedCommerces;
    }

    public List<Post> getSavedPosts() {
        return savedPosts;
    }

    public void setSavedPosts(List<Post> savedPosts) {
        this.savedPosts = savedPosts;
    }

    public List<Commerce> getFavoriteCommerces() {
        return favoriteCommerces;
    }

    public void setFavoriteCommerces(List<Commerce> favoriteCommerces) {
        this.favoriteCommerces = favoriteCommerces;
    }
}
