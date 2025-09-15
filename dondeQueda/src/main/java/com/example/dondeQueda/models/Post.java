package com.example.dondeQueda.models;

import com.example.dondeQueda.enums.EntityType;
import com.example.dondeQueda.repositories.IPostRepository;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post implements ImageOwner {

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

    @ManyToMany(mappedBy = "savedPosts")
    private List<User> users;

    @Transient
    private List<Image> images;

    //Metodos de ImageOwner
    @Override
    public String getEntityType() {
        return EntityType.POST.name();
    }

    @Override
    public List<Image> getImages() {
        return images;
    }

    @Override
    public void setImages(List<Image> images) {
        this.images = images;
    }
}
