package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.FormularioDto;
import com.api.NutriAcess.dtos.LoginDto;
import com.api.NutriAcess.models.FormularioModel;
import com.api.NutriAcess.services.LoginService;

import jakarta.validation.Valid;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    // Injenção de dependência
 
    // final LoginService loginService;

    // public LoginController( LoginService loginService){
    //     this.loginService = loginService;
    // }


    // @PostMapping("/login")
    // public ResponseEntity<Object> loginCliente(@RequestBody @Valid  LoginDto loginDto, BindingResult bindingResult) {

      
    // }
}
