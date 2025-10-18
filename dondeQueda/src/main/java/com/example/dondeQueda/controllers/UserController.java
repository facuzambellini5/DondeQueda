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

    @PostMapping("/agregar/comercio/fav/{idCommerce}/{idUser}")
    public ResponseEntity<?> addCommerceToFavorites(@PathVariable Long idCommerce,
                                                    @PathVariable Long idUser){
        userService.addCommerceToFavorites(idCommerce, idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comercio agregado correctamente.");
    }

    @PostMapping("/eliminar/comercio/fav/{idCommerce}/{idUser}")
    public ResponseEntity<?> removeCommerceFromFavorites(@PathVariable Long idCommerce,
                                                         @PathVariable Long idUser){
        userService.removeCommerceFromFavorites(idCommerce, idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comercio agregado correctamente.");
    }

    @PostMapping("/guardar/post/{idPost}/{idUser}")
    public ResponseEntity<?> addPostToSaved(@PathVariable Long idPost,
                                            @PathVariable Long idUser){
        userService.addPostToSaved(idPost, idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Post guardado correctamente.");
    }

    @PostMapping("/eliminar/post/guardado/{idPost}/{idUser}")
    public ResponseEntity<?> removePostFromSaved(@PathVariable Long idPost,
                                                 @PathVariable Long idUser){
        userService.removePostFromSaved(idPost, idUser);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comercio agregado correctamente.");
    }

}
