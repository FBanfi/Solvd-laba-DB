package com.solvd.bank.domain;

import java.util.Objects;

public class Card {
    private long id;
    private double number;
    private Account account;

    public Card(double number, Account account) {
        this.number = number;
        this.account = account;
    }

    public Card() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
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
        final Card other = (Card) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        if (this.account != other.account) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, account);
    }

    @Override
    public String toString() {
        return "Card{" +
            "id=" + id +
            ", number=" + number +
            ", account=" + account +
            '}';
    }
}
