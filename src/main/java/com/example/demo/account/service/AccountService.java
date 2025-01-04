package com.example.demo.account.service;

import com.example.demo.account.entity.Account;

public interface AccountService {
    Account createAccount(String email);
    Account findAccountByEmail(String email);
}
