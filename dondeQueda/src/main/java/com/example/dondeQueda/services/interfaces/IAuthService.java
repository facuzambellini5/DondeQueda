package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.LoginRequestDto;
import com.example.dondeQueda.dtos.LoginResponseDto;
import com.example.dondeQueda.dtos.RegisterRequestDto;


public interface IAuthService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);

    LoginResponseDto register(RegisterRequestDto registerRequestDto);
}
