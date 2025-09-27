package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.UserDto;
import com.example.dondeQueda.models.User;
import com.example.dondeQueda.repositories.IUserRepository;
import com.example.dondeQueda.services.interfaces.IUserService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepo;

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

        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setPassword(DigestUtils.sha256Hex(user.getSaltPassword().concat(userDto.getPassword())));
        user.setEmail(userDto.getEmail());
        user.setRecoveryEmail(userDto.getRecoveryEmail());
        user.setPhone(userDto.getPhone());

        userRepo.save(user);
    }

    @Override
    public void deleteUserById(Long idUser) {

        User user = this.getUserById(idUser);
        userRepo.delete(user);
    }
}
