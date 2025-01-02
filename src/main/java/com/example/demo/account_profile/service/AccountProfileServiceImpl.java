package com.example.demo.account_profile.service;


import com.example.demo.account.entity.Account;
import com.example.demo.account_profile.entity.AccountProfile;
import com.example.demo.account_profile.repository.AccountProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountProfileServiceImpl implements AccountProfileService {
    final private AccountProfileRepository accountProfileRepository;

    @Override
    public AccountProfile createAccountProfile(Account account, String nickname) {
        AccountProfile accountProfile = new AccountProfile(account, nickname);
        return this.accountProfileRepository.save(accountProfile);
    }
}
