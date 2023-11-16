package com.example.bankapp.controller;

import com.example.bankapp.entity.Transaction;
import com.example.bankapp.service.Impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//связь фронта и бэка
@Controller
//
public class MainController {

    @Autowired
    TransactionServiceImpl transactionServiceImpl;

    @GetMapping("/main") //get запрос для вывода страницы мейн
    public String main(Map<String, Object> model) {
        //получаем все трансакции и записываем их в модель
        Iterable<Transaction> transactions = transactionServiceImpl.getAll();

        model.put("transactions", transactions);

        return "main"; //возвращаем имя файла
    }


    @PostMapping(path="/add")       // Добавляем сообщение
    public @ResponseBody String addTransaction (@RequestParam
                                            String sender, @RequestParam String description){

        Transaction transaction = new Transaction(); //добавляем трансакцию

       // transaction.setSender(name);
        transaction.setDescription(description);
        transactionServiceImpl.save(transaction);


        return "saved";
    }

    @GetMapping(path="/all")       // Возвращаем все сообщения
    public @ResponseBody Iterable<Transaction> findAllTransactions(){

        return transactionServiceImpl.getAll();
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
      //  Iterable<Transaction> transactions = transactionService.findBySender(filter);
      //  model.put("transaction", transactions);
        return "main";
    }
}
