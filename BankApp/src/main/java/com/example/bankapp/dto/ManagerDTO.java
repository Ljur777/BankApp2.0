package com.example.bankapp.dto;

public record ManagerDTO(
        String id,
        String first_name,
        String last_name,
        String status,
        String created_at,
        String updated_at
) {
}
