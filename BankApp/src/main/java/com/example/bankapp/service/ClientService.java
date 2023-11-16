package com.example.bankapp.service;

import com.example.bankapp.dto.ClientCreateDTO;
import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.Client;
import com.example.bankapp.entity.enums.ClientStatus;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.List;

public interface ClientService {
    List<ClientDTO> getByStatus(ClientStatus status);
    UserDetails loadUserByUsername(String userName);
    List<Client> getAll();
    boolean save(ClientDTO client);
    List<ClientDTO> getAllClientsWhereBalanceMoreThan(BigDecimal balance);
    ClientDTO createClient(ClientCreateDTO clientCreateDTO);
    List<ClientDTO> getAllClientsWhereTransactionMoreThan(int transaction);


}
