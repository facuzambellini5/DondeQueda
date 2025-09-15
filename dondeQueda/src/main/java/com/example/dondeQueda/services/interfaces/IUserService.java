package com.example.dondeQueda.services.interfaces;
import com.example.dondeQueda.models.User;

import java.util.List;

public interface IUserService {

    String saveUser(UserDto UserDto);

    List<User> getUsers();

    User getUerById(Long idUser);

    String editUser(Long idUser, UserDto UserDto);

    String deleteUserById(Long idUser);

}
