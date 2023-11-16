package com.example.bankapp.entity.exeptions;

public class AccountNotFoundExeption extends RuntimeException{
    public AccountNotFoundExeption(String message){
        super(message);
    }
}
