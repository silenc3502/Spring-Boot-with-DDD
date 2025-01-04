package com.example.demo.account.service;

import com.example.demo.account.entity.Account;
import com.example.demo.account.entity.AccountRoleType;
import com.example.demo.account.entity.RoleType;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.repository.AccountRoleTypeRepository;
import com.example.demo.kakao_authentication.repository.KakaoAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    final private AccountRepository accountRepository;
    final private AccountRoleTypeRepository accountRoleTypeRepository;

    @Override
    public Account createAccount(String email) {
        AccountRoleType accountRoleType = new AccountRoleType(RoleType.NORMAL);
        AccountRoleType createdAccountRoleType = this.accountRoleTypeRepository.save(accountRoleType);

        Account account = new Account(email, createdAccountRoleType);
        return this.accountRepository.save(account);
    }

    @Override
    public Account findAccountByEmail(String email) {
        Optional<Account> accountOptional = accountRepository.findByEmail(email);
        return accountOptional.orElse(null);
    }
}
