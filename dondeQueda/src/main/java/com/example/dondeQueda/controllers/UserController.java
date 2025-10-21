package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.UserDto;
import com.example.dondeQueda.models.User;
import com.example.dondeQueda.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/guardar")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto){

        userService.saveUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente.");
    }

    @GetMapping("/traer")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/traer/{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable Long idUser){
        return ResponseEntity.ok(userService.getUserById(idUser));
    }

    @PutMapping("/editar/{idUser}")
    public ResponseEntity<?> editUser(@PathVariable Long idUser,
                                      @RequestBody UserDto userDto){
        userService.editUser(idUser,userDto);
        return ResponseEntity.ok("Usuario editado correctamente.");
    }

    @DeleteMapping("/eliminar/{idUser}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long idUser){

        userService.deleteUserById(idUser);

        return ResponseEntity.ok("Usuario eliminado correctamente.");
    }

    @PostMapping("/agregar/comercio/fav/{idUser}/{idCommerce}")
    public ResponseEntity<?> addCommerceToFavorites(@PathVariable Long idUser,
                                                    @PathVariable Long idCommerce){
        userService.addCommerceToFavorites(idUser, idCommerce);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comercio agregado correctamente.");
    }

    @PostMapping("/eliminar/comercio/fav/{idUser}/{idCommerce}")
    public ResponseEntity<?> removeCommerceFromFavorites(@PathVariable Long idUser,
                                                         @PathVariable Long idCommerce){
        userService.removeCommerceFromFavorites(idUser, idCommerce);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comercio agregado correctamente.");
    }

    @PostMapping("/guardar/post/{idUser}/{idPost}")
    public ResponseEntity<?> addPostToSaved(@PathVariable Long idUser,
                                            @PathVariable Long idPost){
        userService.addPostToSaved(idUser, idPost);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Post guardado correctamente.");
    }

    @PostMapping("/eliminar/post/guardado/{idUser}/{idPost}")
    public ResponseEntity<?> removePostFromSaved(@PathVariable Long idUser,
                                                 @PathVariable Long idPost){
        userService.removePostFromSaved(idUser, idPost);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comercio agregado correctamente.");
    }

}
