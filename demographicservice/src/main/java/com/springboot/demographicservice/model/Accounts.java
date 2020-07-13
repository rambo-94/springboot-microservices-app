package com.springboot.demographicservice.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;

    @Column(name = "accountNumber")
    public Long accountNumber;
    @Column(name = "accountType")
    public String accountType;
    @Column(name = "balance")
    public double balance;
}
