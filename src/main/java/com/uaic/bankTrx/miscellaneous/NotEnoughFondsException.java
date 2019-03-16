package com.uaic.bankTrx.miscellaneous;

public class NotEnoughFondsException extends RuntimeException{
    public NotEnoughFondsException(Double amound){super("Not enough funds: " + amound);}

}
