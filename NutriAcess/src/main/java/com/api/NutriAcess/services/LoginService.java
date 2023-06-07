package com.api.NutriAcess.services;

import com.api.NutriAcess.repositories.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    //Injenção de dependencias
    private final LoginRepository loginRepository;


    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

}
