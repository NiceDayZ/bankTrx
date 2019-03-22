package com.uaic.bankTrx.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class Login implements Serializable {

    @Id
    @GeneratedValue
    public Long id;

    public String username;

    public String password;

    public String grantedAuthorities;



    public Login(String userID, String password) {
        username = userID;
        this.password = password;

    }
}
