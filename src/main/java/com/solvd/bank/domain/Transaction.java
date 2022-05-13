package com.solvd.bank.domain;

import java.util.Objects;

public class Transaction {
    private long id;
    private double money;
    private double destinationCBU;
    private Account account;

    public Transaction(double money, double destinationCBU, Account account) {
        this.money = money;
        this.destinationCBU = destinationCBU;
        this.account = account;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Transaction other = (Transaction) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.money != other.money) {
            return false;
        }
        if (this.destinationCBU != other.destinationCBU) {
            return false;
        }
        if (this.account != other.account) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money, destinationCBU,account);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getDestinationCBU() {
        return destinationCBU;
    }

    public void setDestinationCBU(double destinationCBU) {
        this.destinationCBU = destinationCBU;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
