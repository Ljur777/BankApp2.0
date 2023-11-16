package com.example.bankapp.controller;

import com.example.bankapp.dto.AccountCreateDTO;
import com.example.bankapp.dto.AccountDTO;
import com.example.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @GetMapping(path= "/allAccounts")
    public List<AccountDTO> getAllAccounts() throws AccountNotFoundException {
        try {
            return accountService.getAllAccounts();
        } catch (AccountNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> getAllAccountByStatus(@PathVariable int id, @PathVariable("status") String status) throws AccountNotFoundException {
        return accountService.getAllAccountsByStatus(status);
    }

    @GetMapping(path = "/productId/{id}/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> getAccountWithAccountIdAndStatusIs(@PathVariable long id, @PathVariable("status") String status){
        return accountService.getAccountWithAccountIdAndStatusIs(id, status);
    }
    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.OK)
    public <AccountCreateDTO> AccountDTO createAccount(@RequestBody AccountCreateDTO accountCreateDTO){
        return accountService.accountCreateDTO((com.example.bankapp.dto.AccountCreateDTO) accountCreateDTO);
    }
}

