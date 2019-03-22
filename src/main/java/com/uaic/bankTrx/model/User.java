package com.uaic.bankTrx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class User{

    @Id @GeneratedValue
    private Long id;

    private String name;

    private Double amound;


    public User(String name, Double amound) {
        this.name = name;
        this.amound = amound;

    }

}
