package com.example.dondeQueda.models;

import com.example.dondeQueda.enums.CommerceType;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

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
  private CommerceType commerceType = CommerceType.PRIVATE;

  private String email;

  @Column(name = "created_date")
  @UpdateTimestamp
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

  @OneToMany(mappedBy = "commerce", orphanRemoval = true)
  private List<Schedule> schedules;

  @ManyToMany
  @JoinTable(
      name = "commerce_category",
      joinColumns = @JoinColumn(name = "id_commerce"),
      inverseJoinColumns = @JoinColumn(name = "id_category"))
  private List<Category> categories;

  @ManyToMany
  @JoinTable(
      name = "event_commerce",
      joinColumns = @JoinColumn(name = "id_commerce"),
      inverseJoinColumns = @JoinColumn(name = "id_event"))
  private List<Event> events;

  @ManyToMany
  @JoinTable(
      name = "commerce_tag",
      joinColumns = @JoinColumn(name = "id_commerce"),
      inverseJoinColumns = @JoinColumn(name = "id_tag"))
  private List<Tag> tags;

  @OneToMany(mappedBy = "commerce")
  private List<Image> images;

  public Commerce() {}

  public Commerce(
      Long idCommerce,
      String name,
      String description,
      String phone,
      String link,
      CommerceType commerceType,
      String email,
      LocalDateTime createdDate,
      Commerce branchOf,
      List<Commerce> commerces,
      User owner,
      List<Post> posts,
      Address address,
      List<Schedule> schedules,
      List<Category> categories,
      List<Event> events,
      List<Tag> tags,
      List<Image> images) {
    this.idCommerce = idCommerce;
    this.name = name;
    this.description = description;
    this.phone = phone;
    this.link = link;
    this.commerceType = commerceType;
    this.email = email;
    this.createdDate = createdDate;
    this.branchOf = branchOf;
    this.commerces = commerces;
    this.owner = owner;
    this.posts = posts;
    this.address = address;
    this.schedules = schedules;
    this.categories = categories;
    this.events = events;
    this.tags = tags;
    this.images = images;
  }

  public Long getIdCommerce() {
    return idCommerce;
  }

  public void setIdCommerce(Long idCommerce) {
    this.idCommerce = idCommerce;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public CommerceType getCommerceType() {
    return commerceType;
  }

  public void setCommerceType(CommerceType commerceType) {
    this.commerceType = commerceType;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public Commerce getBranchOf() {
    return branchOf;
  }

  public void setBranchOf(Commerce branchOf) {
    this.branchOf = branchOf;
  }

  public List<Commerce> getCommerces() {
    return commerces;
  }

  public void setCommerces(List<Commerce> commerces) {
    this.commerces = commerces;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Schedule> getSchedules() {
    return schedules;
  }

  public void setSchedules(List<Schedule> schedules) {
    this.schedules = schedules;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public List<Event> getEvents() {
    return events;
  }

  public void setEvents(List<Event> events) {
    this.events = events;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }
}
