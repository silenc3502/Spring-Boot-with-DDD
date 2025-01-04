package com.example.demo.account.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 32, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_type_id", nullable = false)
    private AccountRoleType roleType;

    public Account() {
    }

    public Account(String email, AccountRoleType roleType) {
        this.email = email;
        this.roleType = roleType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountRoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(AccountRoleType roleType) {
        this.roleType = roleType;
    }
}
