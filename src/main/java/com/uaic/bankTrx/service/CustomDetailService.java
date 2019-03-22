package com.uaic.bankTrx.service;



import com.uaic.bankTrx.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomDetailService implements UserDetailsService {

    @Autowired
    private LoginRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        return repo.findByUsername(username).map(u -> new User(u.getUsername(), u.getPassword(),true,true,true,true, new ArrayList<>())).orElseThrow(() -> new UsernameNotFoundException("No login found"));

    }
}
