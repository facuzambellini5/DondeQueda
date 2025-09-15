package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.UserDto;
import com.example.dondeQueda.models.User;
import com.example.dondeQueda.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/guardar")
    public String saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @GetMapping("/traer")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/traer/{idUser}")
    public User getUserById(@PathVariable Long idUser){
        return userService.getUserById(idUser);
    }

    @PutMapping("/editar/{idUser}")
    public String editUser(@PathVariable Long idUser,
                           @RequestBody UserDto userDto){
        return userService.editUser(idUser,userDto);
    }

    @DeleteMapping("/eliminar/{idUser}")
    public String deleteUserById(@PathVariable Long idUser){
        return userService.deleteUserById(idUser);
    }
}
