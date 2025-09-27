package com.example.dondeQueda.services.interfaces;


import com.example.dondeQueda.dtos.UserDto;
import com.example.dondeQueda.models.User;

import java.util.List;

public interface IUserService {

    void saveUser(UserDto UserDto);

    List<User> getUsers();

    User getUserById(Long idUser);

    void editUser(Long idUser, UserDto userDto);

    void deleteUserById(Long idUser);


}
