package com.uaic.bankTrx.init;

import com.uaic.bankTrx.model.Transaction;
import com.uaic.bankTrx.model.User;
import com.uaic.bankTrx.repository.TransactionRepository;
import com.uaic.bankTrx.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository, TransactionRepository transactionRepository){
        return args -> {
          log.info("Preloading " + repository.save(new User("Bilbo Baggins", 123D)));
          log.info("Preloading " + repository.save(new User("Frodo Baggins", 400D)));

          log.info("Transaction " + transactionRepository.save(new Transaction(1L, 2L, 10D)));


        };
    }


}
