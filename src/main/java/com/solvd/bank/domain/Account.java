package com.solvd.bank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    @JsonProperty("aid")
    private long id;
    @JsonProperty("balance")
    private double balance;
    @JsonProperty("cbu")
    private double cbu;
    @JsonProperty("alias")
    private String alias;
    private List<Credit> credits = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Debt> debts = new ArrayList<>();
    private List<Deposit> deposits = new ArrayList<>();
    private List<Whitdrawal> whitdrawals = new ArrayList<>();
    private List<Investment> investments = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();
    private List<Subscription> subscriptions = new ArrayList<>();

    public Account(double balance, double cbu, String alias) {
        this.balance = balance;
        this.cbu = cbu;
        this.alias = alias;
    }

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCbu() {
        return cbu;
    }

    public void setCbu(double cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Debt> getDebts() {
        return debts;
    }

    public void setDebts(List<Debt> debts) {
        this.debts = debts;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    public List<Whitdrawal> getWhitdrawals() {
        return whitdrawals;
    }

    public void setWhitdrawals(List<Whitdrawal> whitdrawals) {
        this.whitdrawals = whitdrawals;
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(List<Investment> investments) {
        this.investments = investments;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.balance != other.balance) {
            return false;
        }
        if (this.cbu != other.cbu) {
            return false;
        }
        if (this.alias != other.alias) {
            return false;
        }
        if (this.credits != other.credits) {
            return false;
        }
        if (this.transactions != other.transactions) {
            return false;
        }
        if (this.debts != other.debts) {
            return false;
        }
        if (this.deposits != other.deposits) {
            return false;
        }
        if (this.whitdrawals != other.whitdrawals) {
            return false;
        }
        if (this.investments != other.investments) {
            return false;
        }
        if (this.payments != other.payments) {
            return false;
        }
        if (this.cards != other.cards) {
            return false;
        }
        if (this.subscriptions != other.subscriptions) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, cbu, alias, credits, transactions, debts,
                deposits, whitdrawals, investments, payments, cards, subscriptions);
    }

    @Override
    public String toString() {
        return "Account{" +
            "id=" + id +
            ", balance=" + balance +
            ", cbu=" + cbu +
            ", alias='" + alias + '\'' +
            ", credits=" + credits +
            ", transactions=" + transactions +
            ", debts=" + debts +
            ", deposits=" + deposits +
            ", whitdrawals=" + whitdrawals +
            ", investments=" + investments +
            ", payments=" + payments +
            ", cards=" + cards +
            ", subscriptions=" + subscriptions +
            '}';
    }
}
