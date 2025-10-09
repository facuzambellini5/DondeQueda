package com.example.dondeQueda.dtos;

public class CommerceDto {

    private String name;
    private String description;
    private String phone;
    private String link;
    private String email;
    private Long branchOf;
    private Long idOwner;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getLink() {
        return link;
    }

    public String getEmail() {
        return email;
    }

    public Long getBranchOf() {
        return branchOf;
    }

    public Long getIdOwner() {
        return idOwner;
    }
}
