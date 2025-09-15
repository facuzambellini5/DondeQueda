package com.example.dondeQueda.services.interfaces;


import com.example.dondeQueda.dtos.UserDto;
import com.example.dondeQueda.models.User;

import java.util.List;

public interface IUserService {

    String saveUser(UserDto UserDto);

    List<User> getUsers();

    User getUserById(Long idUser);

    String editUser(Long idUser, UserDto userDto);

    String deleteUserById(Long idUser);

}
