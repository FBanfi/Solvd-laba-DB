package com.solvd.bank.domain;

import java.util.Objects;

public class Whitdrawal {
    private long id;
    private double money;
    private Account account;

    public Whitdrawal(double money, Account account) {
        this.money = money;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
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
        final Whitdrawal other = (Whitdrawal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.money != other.money) {
            return false;
        }
        if (this.account != other.account) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money, account);
    }

    @Override
    public String toString() {
        return "Whitdrawal{" +
            "id=" + id +
            ", money=" + money +
            ", account=" + account +
            '}';
    }
}
