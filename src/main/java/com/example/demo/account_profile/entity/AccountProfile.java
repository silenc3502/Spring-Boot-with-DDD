package com.example.demo.account_profile.entity;

import com.example.demo.account.entity.Account;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "account_profile")
public class AccountProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", length = 32, unique = true, nullable = false)
    private String nickname;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    public AccountProfile() {
    }

    public AccountProfile(Account account, String nickname) {
        this.account = account;
        this.nickname = nickname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

