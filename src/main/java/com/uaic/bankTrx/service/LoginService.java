package com.uaic.bankTrx.service;


import com.uaic.bankTrx.model.Login;
import com.uaic.bankTrx.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public void save(Login user){
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }
}
