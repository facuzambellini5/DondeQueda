package com.example.dondeQueda.dtos;

import com.example.dondeQueda.enums.UserRole;
import com.example.dondeQueda.models.User;

//TODO: IMPLEMENTAR CON TOKENS
public class LoginResponseDto {

    //private String token;
    private Long idUser;
    private String username;
    private String name;
    private String lastname;
    private UserRole role;
    private String email;
    private String recoveryEmail;
    private String phone;
    //private LocalDateTime expiresAt;


    public LoginResponseDto() {
    }

    public LoginResponseDto(User user){
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.role = user.getRole();
        this.email = user.getEmail();
        this.recoveryEmail = user.getRecoveryEmail();
        this.phone = user.getPhone();
        //this.expiresAt = expiresAt;
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
}