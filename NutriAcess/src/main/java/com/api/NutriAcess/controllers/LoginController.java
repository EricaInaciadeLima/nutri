package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.LoginDto;
import com.api.NutriAcess.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    // Injenção de dependência
    final LoginService loginService;

    public LoginController( LoginService loginService){
        this.loginService = loginService;
    }

   /* @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto){
        try {

        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
        return
    }*/
}
