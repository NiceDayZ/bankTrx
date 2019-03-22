package com.uaic.bankTrx.controller;

import com.uaic.bankTrx.miscellaneous.NotEnoughFondsException;
import com.uaic.bankTrx.miscellaneous.UserNotFoundException;
import com.uaic.bankTrx.model.Transaction;
import com.uaic.bankTrx.model.User;
import com.uaic.bankTrx.repository.TransactionRepository;
import com.uaic.bankTrx.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionRepository repository;
    private final UserRepository userRepository;


    public TransactionController(TransactionRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping("/transactions")
    List<Transaction> all(){
        return repository.findAll();
    }

    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction newTransaction){
        User from = userRepository.findById(newTransaction.getFromUser())
                .orElseThrow(()-> new UserNotFoundException(newTransaction.getFromUser()));
        User to = userRepository.findById(newTransaction.getToUser())
                .orElseThrow(()-> new UserNotFoundException(newTransaction.getToUser()));

        if(from.getAmound() >= newTransaction.getAmound()){
            from.setAmound(from.getAmound() - newTransaction.getAmound());
            to.setAmound(to.getAmound() + newTransaction.getAmound());
            userRepository.save(from);
            userRepository.save(to);
            return repository.save(newTransaction);
        }else{
            throw new NotEnoughFondsException(newTransaction.getAmound());
        }

    }


}
