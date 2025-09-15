package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.UserDto;
import com.example.dondeQueda.models.User;
import com.example.dondeQueda.repositories.IUserRepository;
import com.example.dondeQueda.services.interfaces.IEntityValidatorService;
import com.example.dondeQueda.services.interfaces.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepo;

    @Autowired
    private IEntityValidatorService validatorService;

    @Override
    public String saveUser(UserDto userDto) {

        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setPassword(DigestUtils.sha256Hex(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRecoveryEmail(userDto.getRecoveryEmail());
        user.setPhone(userDto.getPhone());

        userRepo.save(user);

        return "Usuario guardado correctamente.";
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long idUser) {
        return validatorService.validateUser(idUser);
    }

    @Override
    public String editUser(Long idUser, UserDto userDto) {

        User user = validatorService.validateUser(idUser);

        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setPassword(DigestUtils.sha256Hex(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRecoveryEmail(userDto.getRecoveryEmail());
        user.setPhone(userDto.getPhone());

        return "Usuario editado correctamente.";
    }

    @Override
    public String deleteUserById(Long idUser) {

        User user = validatorService.validateUser(idUser);
        userRepo.delete(user);

        return "Usuario eliminado correctamente.";
    }
}
