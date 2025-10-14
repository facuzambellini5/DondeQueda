package com.example.dondeQueda.dtos;

import com.example.dondeQueda.enums.CommerceType;
import com.example.dondeQueda.enums.ImageType;
import com.example.dondeQueda.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CommerceDtoResponse {

    private Long idCommerce;
    private String name;
    private String description;
    private String phone;
    private String link;
    private CommerceType commerceType;
    private String email;
    private List<Post> posts;
    private Address address;
    private List<Schedule> schedules;
    private List<Category> categories;
    private List<Event> events;
    private List<Tag> tags;


    private ImageDto profileImage;
    private ImageDto coverImage;
    private List<ImageDto> galleryImages;

    public CommerceDtoResponse(Commerce commerce) {
        this.idCommerce = commerce.getIdCommerce();
        this.name = commerce.getName();
        this.description = commerce.getDescription();
        this.phone = commerce.getPhone();
        this.link = commerce.getLink();
        this.commerceType = commerce.getCommerceType();
        this.email = commerce.getEmail();
        this.posts = commerce.getPosts();
        this.address = commerce.getAddress();
        this.schedules = commerce.getSchedules();
        this.categories = commerce.getCategories();
        this.events = commerce.getEvents();
        this.tags = commerce.getTags();

        this.galleryImages = new ArrayList<>();

        for (Image image : commerce.getImages()){

            ImageDto imageDto = new ImageDto(image);

            if (image.getImageType() == ImageType.PROFILE) {
                this.profileImage = imageDto;
            } else if (image.getImageType() == ImageType.COVER) {
                this.coverImage = imageDto;
            } else if (image.getImageType() == ImageType.GALLERY) {
                this.galleryImages.add(imageDto);
            }
        }

        //Esto ordena las imagenes segun su ImageOrder
        this.galleryImages.sort(Comparator.comparing(ImageDto::getImageOrder));
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

    public ImageDto getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ImageDto profileImage) {
        this.profileImage = profileImage;
    }

    public ImageDto getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(ImageDto coverImage) {
        this.coverImage = coverImage;
    }

    public List<ImageDto> getGalleryImages() {
        return galleryImages;
    }

    public void setGalleryImages(List<ImageDto> galleryImages) {
        this.galleryImages = galleryImages;
    }
}
