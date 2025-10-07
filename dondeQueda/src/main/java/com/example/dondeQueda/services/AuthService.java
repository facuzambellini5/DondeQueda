package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.LoginRequestDto;
import com.example.dondeQueda.dtos.LoginResponseDto;
import com.example.dondeQueda.dtos.RegisterRequestDto;
import com.example.dondeQueda.dtos.UserDto;
import com.example.dondeQueda.models.User;
import com.example.dondeQueda.repositories.IUserRepository;
import com.example.dondeQueda.services.interfaces.IAuthService;
import com.example.dondeQueda.services.interfaces.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

  @Autowired private IUserService userService;
  @Autowired private IUserRepository userRepo;

  @Override
  public LoginResponseDto login(LoginRequestDto loginRequestDto) {
    User user =
        userService
            .getUserByEmail(loginRequestDto.getEmail())
            .orElseThrow(() -> new BadCredentialsException("Email o contraseña incorrecto/s"));

    //Calculo Hash del loginRequest para compararlo con el Hash del User
    String loginHashPassword = DigestUtils.sha256Hex(user.getSaltPassword().concat(loginRequestDto.getPassword()));

    if (!loginHashPassword.equals(user.getPassword())){
        throw new BadCredentialsException("Email o contraseña incorrecto/s");
    }
    return new LoginResponseDto(user);
  }

  @Override
  public LoginResponseDto register(RegisterRequestDto registerRequestDto) {

      if(userRepo.existsByEmail(registerRequestDto.getEmail())){
          throw new IllegalArgumentException("El email ya existe.");
      }

      UserDto userDto = new UserDto();

      userDto.setEmail(registerRequestDto.getEmail());
      userDto.setPassword(registerRequestDto.getPassword());

      userService.saveUser(userDto);

      User user = userRepo.findByEmail(userDto.getEmail()).orElseThrow();

      return new LoginResponseDto(user);
  }
}
