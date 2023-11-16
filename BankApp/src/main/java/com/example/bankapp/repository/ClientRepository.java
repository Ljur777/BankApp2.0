package com.example.bankapp.repository;

import com.example.bankapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;


public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByName(String userName);
}
