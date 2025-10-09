package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.LoginRequestDto;
import com.example.dondeQueda.dtos.LoginResponseDto;
import com.example.dondeQueda.dtos.RegisterRequestDto;
import com.example.dondeQueda.services.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired private IAuthService authService;

  @PostMapping("/login")
  ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
    try {
      return ResponseEntity.ok(authService.login(loginRequestDto));
    } catch (BadCredentialsException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email o contraseña incorrecto/s");
    }
  }

  @PostMapping("/registrarse")
  ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequestDto){
    try{
      LoginResponseDto loginResponseDto = authService.register(registerRequestDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(loginResponseDto);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
