package com.example.bankapp.service.Impl;

import com.example.bankapp.entity.Transaction;
import com.example.bankapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl {
    @Autowired
    TransactionRepository transactionRepository;

    //метод для полученя доступу к всем трансакциям
    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }
    public void save(Transaction transaction){
        transactionRepository.save(transaction);
    }
    /*
    public List<Transaction> findBySender(String filter){
        List<Transaction> transactions;
        if (filter != null && !filter.isEmpty()) {
            transactions = transactionRepository.findBySender(filter);
        } else {
            transactions = transactionRepository.findAll();
        }
        return transactions;
    }

     */
}
