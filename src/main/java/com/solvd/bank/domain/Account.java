package com.solvd.bank.domain;

import java.util.List;

public class Account {
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

}
