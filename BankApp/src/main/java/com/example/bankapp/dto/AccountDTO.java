package com.example.bankapp.dto;

import lombok.Data;


@Data
public class AccountDTO {
    String id;
    String name;
    String type;
    String status;
    String balance;
    String currencyCode;
    String created_at;
    String updated_at;
    String client_id;
}

