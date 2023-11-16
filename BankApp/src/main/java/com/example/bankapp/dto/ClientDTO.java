package com.example.bankapp.dto;

import com.example.bankapp.entity.enums.ClientStatus;
import lombok.Data;

@Data
public class ClientDTO{
        String id;
        ClientStatus status;
        String taxCode;
        String firstName;
        String lastName;
        String email;
        String address;
        String phone;
        String createdAt;
        String updatedAt;
        String managerId;
}
