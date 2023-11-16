package com.example.bankapp.controller;

import com.example.bankapp.dto.ClientCreateDTO;
import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.enums.ClientStatus;
import com.example.bankapp.service.Impl.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientServiceImpl clientServiceImpl;
    private ClientDTO clientDTO;

    @GetMapping(path = "/active")
    public List<ClientDTO> getAllActiveStatusClients(ClientStatus status){
        clientDTO = new ClientDTO();
        status = clientDTO.getStatus();
        return clientServiceImpl.getByStatus(status);
    }

    @GetMapping(path="/balance/{balance}")
    public List<ClientDTO> getAllClientsWhereBalanceMoreThan(@PathVariable("balance") BigDecimal balance){
        return clientServiceImpl.getAllClientsWhereBalanceMoreThan(balance);
    }
    @GetMapping(path="/transaction/{transaction}")
    public List<ClientDTO> getAllClientsWhereTransactionMoreThan(@PathVariable("transaction") int transaction){
        return clientServiceImpl.getAllClientsWhereTransactionMoreThan(transaction);
    }
    @PostMapping(path="/create")
    public ClientDTO createClient(@RequestBody ClientCreateDTO clientCreateDTO){
        return clientServiceImpl.createClient(clientCreateDTO);
    }

}
