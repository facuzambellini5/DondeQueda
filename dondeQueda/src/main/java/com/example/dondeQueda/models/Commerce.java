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

    @Column(name = "branch_of")
    @ManyToOne
    @JoinColumn(name = "commerce_id")
    private Commerce branchOf;

    @OneToMany(mappedBy = "branchOf")
    private List<Commerce> commerces;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User owner;

    //Relaciones faltantes:
    //Schedule, User, Address

}
