package com.api.NutriAcess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class NutriAcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutriAcessApplication.class, args);
	}

}
