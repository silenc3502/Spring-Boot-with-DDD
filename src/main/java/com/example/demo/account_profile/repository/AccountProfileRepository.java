package com.example.demo.account_profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.account_profile.entity.AccountProfile;

public interface AccountProfileRepository extends JpaRepository<AccountProfile, Long> {
}
