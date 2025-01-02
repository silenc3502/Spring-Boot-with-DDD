package com.example.demo.account_profile.service;

import com.example.demo.account.entity.Account;
import com.example.demo.account_profile.entity.AccountProfile;

public interface AccountProfileService {
    AccountProfile createAccountProfile(Account account, String nickname);
}
