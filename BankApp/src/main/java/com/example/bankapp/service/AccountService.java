package com.example.bankapp.service;

import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.dto.AccountCreateDTO;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountService {
    List<AccountDTO> getAllAccountsByStatus(String status) throws AccountNotFoundException;

    List<AccountDTO> getAllAccounts() throws AccountNotFoundException;

    List<AccountDTO> getAccountWithAccountIdAndStatusIs(long id, String status);

    AccountDTO accountCreateDTO(AccountCreateDTO accountCreateDTO);
}
