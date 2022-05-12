package com.solvd.bank.domain.connectionPool;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String message){
        super(message);
    }
}
