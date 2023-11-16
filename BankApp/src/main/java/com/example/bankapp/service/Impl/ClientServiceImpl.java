package com.example.bankapp.service.Impl;

import com.example.bankapp.dto.ClientCreateDTO;
import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.Client;
import com.example.bankapp.entity.enums.ClientStatus;
import com.example.bankapp.mapper.ClientMapper;
import com.example.bankapp.repository.ClientRepository;
import com.example.bankapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements UserDetailsService, ClientService {
    @Autowired
    private ClientRepository clientRepository;
 //   @Autowired                                      // Получаем шифровальщика паролей
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return clientRepository.findByName(userName);
    }
  public List<ClientDTO> getAll(){
    return clientRepository.findAll().stream()
            .map(ClientMapper::mapToClientDTO)
            .collect(Collectors.toList());
  }


    public boolean save(Client client){
       // client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
        return true;
  }


    public List<ClientDTO> getAllClientsWhereBalanceMoreThan(BigDecimal balance) {
        return null;
    }

    public ClientDTO createClient(ClientCreateDTO clientCreateDTO) {
        return null;
    }

    public List<ClientDTO> getAllClientsWhereTransactionMoreThan(int transaction) {
        return null;
    }

    @Override
    public List<ClientDTO> getByStatus(ClientStatus status) {
        return clientRepository.findAll().stream()
                .filter(clientStatus -> clientStatus.getClientStatus().equals(status))
                .collect(Collectors.toList());
    }
}
