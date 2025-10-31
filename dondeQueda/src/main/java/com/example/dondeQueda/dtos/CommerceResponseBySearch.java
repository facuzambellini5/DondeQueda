package com.example.dondeQueda.dtos;

import com.example.dondeQueda.enums.ImageType;
import com.example.dondeQueda.models.*;

import java.util.List;

public class CommerceResponseBySearch {

    private Long idCommerce;
    private String name;
    private String description;
    private List<Schedule> schedules;
    private List<Category> categories;
    private ImageDto profileImage;
    private ImageDto coverImage;

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

    public CommerceResponseBySearch(Commerce commerce) {
        this.idCommerce = commerce.getIdCommerce();
        this.name = commerce.getName();
        this.description =  commerce.getDescription();
        this.schedules = commerce.getSchedules();
        this.categories = commerce.getCategories();

        for(Image image : commerce.getImages()){

            if(image.getImageType() == ImageType.PROFILE){
                this.profileImage = new ImageDto(image);
            }
            if(image.getImageType() == ImageType.COVER){
                this.coverImage = new ImageDto(image);
            }
        }


    }
}
