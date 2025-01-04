package com.example.demo.account_profile.repository;

import com.example.demo.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.account_profile.entity.AccountProfile;

import java.util.Optional;

public interface AccountProfileRepository extends JpaRepository<AccountProfile, Long> {
    Optional<AccountProfile> findByAccount(Account account);
}
