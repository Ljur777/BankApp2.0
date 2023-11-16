package com.example.bankapp.entity.exeptions;

public class DataBaseExeption extends Exception{
    public DataBaseExeption(String message) {
        super(message);
        System.out.println("Произошла ошибка" + message);
    }
}
