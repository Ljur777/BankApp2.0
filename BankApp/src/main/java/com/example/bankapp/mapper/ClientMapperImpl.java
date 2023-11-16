package com.example.bankapp.mapper;

import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.Client;
import com.example.bankapp.entity.enums.ClientStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ClientMapperImpl {
    Long id;
    ClientStatus status;
    Integer taxCode;
    String firstName;
    String lastName;
    String email;
    String address;
    String phone;
    String createdAt;
    String updatedAt;
    String managerId;
    ClientDTO mapToClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(String.valueOf(client.getClientId()));
        clientDTO.setStatus(client.getClientStatus());
        clientDTO.setTaxCode(client.getTaxCode());
        return clientDTO;
    }
}
