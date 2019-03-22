package com.uaic.bankTrx.controller;

import com.uaic.bankTrx.miscellaneous.UserNotFoundException;
import com.uaic.bankTrx.model.User;
import com.uaic.bankTrx.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/users")
    List<User> all(){return repository.findAll();}

    @PostMapping("/users")
    User newUser(@RequestBody User newUser){
        return repository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User user(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    void updateUser(@PathVariable Long id, String name, Double amound){
        //TODO
        if(repository.existsById(id)){
            User user = repository.findById(id).orElseThrow(()->new UserNotFoundException(id));
            user.setName(name);
            user.setAmound(amound);
            repository.save(user);
        }else{
            repository.save(new User(name, amound));
        }
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else throw new UserNotFoundException(id);

    }


}
