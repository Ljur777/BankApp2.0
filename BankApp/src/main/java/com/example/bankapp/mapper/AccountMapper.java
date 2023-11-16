package com.example.bankapp.mapper;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.enums.AccountStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(source = "account.status", target = "account_status");
    @Mapping(source = "account.client.id", target = "client_id");
    @Mapping(source = "transaction.id", target = "transaction_id");
    AccountDTO toDTO(Account account);
    List<AccountDTO> toDTOList(List<Account> accountList);
}
//тут питання