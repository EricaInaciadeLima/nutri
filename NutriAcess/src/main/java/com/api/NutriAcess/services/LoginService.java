package com.api.NutriAcess.services;

import com.api.NutriAcess.dtos.LoginDto;
import com.api.NutriAcess.repositories.LoginRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    //Injenção de dependencias
    private final LoginRepository loginRepository;


    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    public ResponseEntity<Object> validarLogin(LoginDto loginDto) {

       
        return null;
    }
}
