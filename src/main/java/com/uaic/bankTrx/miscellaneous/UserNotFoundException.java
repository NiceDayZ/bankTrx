package com.uaic.bankTrx.miscellaneous;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){super("could not find employee");}
}
