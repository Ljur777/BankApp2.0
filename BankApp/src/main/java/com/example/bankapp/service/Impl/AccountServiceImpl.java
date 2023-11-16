package com.example.bankapp.service.Impl;


import com.example.bankapp.dto.AccountCreateDTO;
import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.Transaction;
import com.example.bankapp.entity.exeptions.ErrorMessage;
import com.example.bankapp.mapper.AccountMapper;
import com.example.bankapp.repository.AccountRepository;
import com.example.bankapp.repository.TransactionRepository;
import com.example.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;



@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    @Autowired
    private final AccountMapper accountMapper;
    @Autowired
    private final AccountRepository accountRepository;

    //метод для полученя доступу к всем cчетам
    @Override
    public List<AccountDTO> getAllAccounts() throws AccountNotFoundException {
        List<Account> accountsStatus = accountRepository.findAll();
        if(accountList == null || accountList.isEmpty()){
            throw new AccountNotFoundException(ErrorMessage.ACCOUNTS_NOT_FOUND);
        }else{
            return accountMapper.toDTOList(accountList);
        }
    }
    //дописати
    @Override
    public List<AccountDTO> getAccountWithAccountIdAndStatusIs(long id, String status) {
        return null;
    }
    //дописати
    @Override
    public AccountDTO accountCreateDTO(AccountCreateDTO accountCreateDTO) {
        return null;
    }


    public void save(Account account) {
        accountRepository.save(account);
    }


    @Override
    public List<AccountDTO> getAllAccountsByStatus(String status) throws AccountNotFoundException {
        List<Account> accountsStatus = accountRepository.getAllByStatusEquals(status);
        if(accountsStatus == null || accountsStatus.isEmpty()){
            throw new AccountNotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND_BY_STATUS);
        }else{
            return accountMapper.toDTOList(accountsStatus);
        }
    }


}
