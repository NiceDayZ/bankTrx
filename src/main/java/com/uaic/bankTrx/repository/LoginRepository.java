package com.uaic.bankTrx.repository;

import com.uaic.bankTrx.model.Login;
import com.uaic.bankTrx.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByUsername(String username);
}
