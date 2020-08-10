package com.springboot.microservice.transactionservice.model;

import javax.persistence.*;

@Entity
@Table(name="FoodCard")
public class FoodCardAccount {


    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name="accountNumber")
    private Long AccountNumber;


    @Column(name ="cardNumber")
    private Long cardNumber;

    @Column(name = "balance")
    private double balance;

    public FoodCardAccount(){}

    public FoodCardAccount(Long accountNumber, Long cardNumber, double balance) {
        AccountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        AccountNumber = accountNumber;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
