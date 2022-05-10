package com.solvd.bank.domain;

import java.util.List;

public class Account {
    private long id;
    private double balance;
    private double cbu;
    private String alias;
    private List<Credit> credits;
    private List<Transaction> transactions;
    private List<Debt> debts;
    private List<Deposit> deposits;
    private List<Whitdrawal> whitdrawals;
    private List<Investment> investments;
    private List<Payment> payments;
    private List<Card> cards;
    private List<Subscription> subscriptions;

    public Account() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return this.balance;
    }
}
