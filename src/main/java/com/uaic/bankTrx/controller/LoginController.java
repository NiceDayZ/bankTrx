package com.uaic.bankTrx.controller;

import com.uaic.bankTrx.model.Login;
import com.uaic.bankTrx.repository.LoginRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    private final LoginRepository repository;

    public LoginController(LoginRepository repository){
        this.repository = repository;
    }

    @GetMapping("/test")
    public List<Login> login(){
        return repository.findAll();
    }
}
