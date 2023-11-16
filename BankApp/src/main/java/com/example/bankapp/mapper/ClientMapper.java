package com.example.bankapp.mapper;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.Client;

import java.util.List;

public interface ClientMapper {

    ClientDTO mapToClientDTO(Client client);
}
