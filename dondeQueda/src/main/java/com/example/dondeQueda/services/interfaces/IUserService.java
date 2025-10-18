package com.example.dondeQueda.services.interfaces;


import com.example.dondeQueda.dtos.UserDto;
import com.example.dondeQueda.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    void saveUser(UserDto UserDto);

    List<User> getUsers();

    User getUserById(Long idUser);

    void editUser(Long idUser, UserDto userDto);

    void deleteUserById(Long idUser);

    Optional<User> getUserByEmail(String email);

    void addCommerceToFavorites(Long idCommerce, Long idUser);

    void removeCommerceFromFavorites(Long idCommerce, Long idUser);

    void addPostToSaved(Long idPost, Long idUser);

    void removePostFromSaved(Long idPost, Long idUser);

}
