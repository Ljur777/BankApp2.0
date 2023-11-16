package com.example.bankapp;

import com.example.bankapp.entity.Client;
import com.example.bankapp.entity.Transaction;
import com.example.bankapp.repository.ClientRepository;
import com.example.bankapp.repository.TransactionRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BankAppApplicationTests {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ClientRepository clientRepository;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Testing is begininig");
        //проверка одного значения для всех обьектов класса. например автоинкремент
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Test start");
    }


//тест на добавление сообщений в БД
    @Test
    public void testAddingMessages() {
        Transaction trx = new Transaction(); //create transaction
        trx.setDescription("pmnt for rent");
        trx.setSender("Tester");

        transactionRepository.save(trx);
        List listOfTransactions = transactionRepository.findAll();
        //before I`ve added 5 trx in my DB table
        Assertions.assertEquals(5, listOfTransactions.size());
        transactionRepository.delete(trx);

    }

    @Test
    public void testAddingClient() {
        Client client = new Client(); //create transaction
        client.setFirstName("User1");
        client.setLastName("User1");

        clientRepository.save(client);
        List listOfClients = clientRepository.findAll();
        //before I`ve added 5 clients in my DB table
        Assertions.assertEquals(5, listOfClients.size());
        clientRepository.delete(client);

    }

    @AfterEach
    public void afterEach(){
        System.out.println("Test finish");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("Testing is finishing");
    }
}
