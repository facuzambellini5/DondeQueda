package com.example.dondeQueda.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTag;

    @Column(name = "name_tag")
    private String nameTag;

    @ManyToMany(mappedBy = "tags")
    private List<Commerce> commerces;

    public Tag() {
    }

    public Tag(Long idTag, String nameTag, List<Commerce> commerces) {
        this.idTag = idTag;
        this.nameTag = nameTag;
        this.commerces = commerces;
    }

    public Long getIdTag() {
        return idTag;
    }

    public void setIdTag(Long idTag) {
        this.idTag = idTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public List<Commerce> getCommerces() {
        return commerces;
    }

    public void setCommerces(List<Commerce> commerces) {
        this.commerces = commerces;
    }
}
