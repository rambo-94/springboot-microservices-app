package com.springboot.demoservice.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Accounts(Long accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;

    @Column(name = "accountNumber")
    public Long accountNumber;
    @Column(name = "accountType")
    public String accountType;

    @Column(name = "balance")
    public double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
