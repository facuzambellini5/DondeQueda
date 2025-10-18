package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.UserDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.models.User;
import com.example.dondeQueda.repositories.ICommerceRepository;
import com.example.dondeQueda.repositories.IPostRepository;
import com.example.dondeQueda.repositories.IUserRepository;
import com.example.dondeQueda.services.interfaces.IUserService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepo;
    @Autowired
    private ICommerceRepository commerceRepo;
    @Autowired
    private IPostRepository postRepo;

    @Override
    public void saveUser(UserDto userDto) {

        User user = new User();
        Random random = new Random();
        String saltPassword = RandomStringUtils.random(4,0,0, true, true, null , random);

        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setSaltPassword(saltPassword);
        user.setPassword(DigestUtils.sha256Hex(saltPassword.concat(userDto.getPassword())));
        user.setEmail(userDto.getEmail());
        user.setRecoveryEmail(userDto.getRecoveryEmail());
        user.setPhone(userDto.getPhone());

        userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long idUser) {
        return ValidationUtils.validateEntity(userRepo.findById(idUser), "Usuario", idUser);
    }

    @Override
    public void editUser(Long idUser, UserDto userDto) {

        User user = this.getUserById(idUser);

        if(userDto.getUsername() != null) {
            user.setUsername(userDto.getUsername());
        }

        if(userDto.getName() != null) {
            user.setName(userDto.getName());
        }

        if(userDto.getLastname() != null) {
            user.setLastname(userDto.getLastname());
        }

        if(userDto.getPassword() != null) {
            user.setPassword(DigestUtils.sha256Hex(user.getSaltPassword().concat(userDto.getPassword())));
        }

        if(userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }

        if(userDto.getRecoveryEmail() != null) {
            user.setRecoveryEmail(userDto.getRecoveryEmail());
        }

        if(userDto.getPassword() != null) {
            user.setPhone(userDto.getPhone());
        }

        if(userDto.getPhone() != null){
            user.setPhone(userDto.getPhone());
        }

        userRepo.save(user);
    }

    @Override
    public void deleteUserById(Long idUser) {

        User user = this.getUserById(idUser);
        userRepo.delete(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void addCommerceToFavorites(Long idCommerce, Long idUser) {

        Commerce commerce = ValidationUtils.validateEntity(commerceRepo.findById(idCommerce), "Comercio", idCommerce);
        User user = this.getUserById(idUser);

        user.getFavoriteCommerces().add(commerce);

        userRepo.save(user);
    }

    @Override
    public void removeCommerceFromFavorites(Long idCommerce, Long idUser) {

        Commerce commerce = ValidationUtils.validateEntity(commerceRepo.findById(idCommerce), "Comercio", idCommerce);
        User user = this.getUserById(idUser);

        user.getFavoriteCommerces().remove(commerce);

        userRepo.save(user);
    }

    @Override
    public void addPostToSaved(Long idPost, Long idUser) {

        Post post = ValidationUtils.validateEntity(postRepo.findById(idPost), "Publicación", idPost);
        User user = this.getUserById(idUser);

        user.getSavedPosts().add(post);

        userRepo.save(user);
    }

    @Override
    public void removePostFromSaved(Long idPost, Long idUser) {

        Post post = ValidationUtils.validateEntity(postRepo.findById(idPost), "Publicación", idPost);
        User user = this.getUserById(idUser);

        user.getSavedPosts().remove(post);

        userRepo.save(user);
    }
}
