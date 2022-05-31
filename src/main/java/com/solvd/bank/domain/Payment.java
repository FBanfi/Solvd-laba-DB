package com.solvd.bank.domain;

import java.util.Objects;

public class Payment {
    private long id;
    private double money;
    private String placeOfPayment;
    private Account account;

    public Payment(double money, String placeOfPayment, Account account) {
        this.money = money;
        this.placeOfPayment = placeOfPayment;
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

    public String getPlaceOfPayment() {
        return placeOfPayment;
    }

    public void setPlaceOfPayment(String placeOfPayment) {
        this.placeOfPayment = placeOfPayment;
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
        final Payment other = (Payment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.money != other.money) {
            return false;
        }
        if (this.placeOfPayment != other.placeOfPayment) {
            return false;
        }
        if (this.account != other.account) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money, placeOfPayment, account);
    }

    @Override
    public String toString() {
        return "Payment{" +
            "id=" + id +
            ", money=" + money +
            ", placeOfPayment='" + placeOfPayment + '\'' +
            ", account=" + account +
            '}';
    }
}
