package com.uaic.bankTrx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Transaction{

    @Id @GeneratedValue
    private Long Id;

    private Long fromUser;

    private Long toUser;

    private Double amound;

    public Transaction(Long fromUser, Long toUser, Double amound) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amound = amound;
    }
}
