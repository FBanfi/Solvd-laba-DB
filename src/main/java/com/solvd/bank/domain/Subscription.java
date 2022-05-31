package com.solvd.bank.domain;

import java.util.List;
import java.util.Objects;

public class Subscription {
    private long id;
    private String serviceDespription;
    private double monthlyCost;
    private List<Account> accounts;

    public Subscription(String serviceDespription, double monthlyCost, List<Account> accounts) {
        this.serviceDespription = serviceDespription;
        this.monthlyCost = monthlyCost;
        this.accounts = accounts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceDespription() {
        return serviceDespription;
    }

    public void setServiceDespription(String serviceDespription) {
        this.serviceDespription = serviceDespription;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Subscription other = (Subscription) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.serviceDespription != other.serviceDespription) {
            return false;
        }
        if (this.monthlyCost != other.monthlyCost) {
            return false;
        }
        if (this.accounts != other.accounts) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceDespription, monthlyCost, accounts);
    }

    @Override
    public String toString() {
        return "Subscription{" +
            "id=" + id +
            ", serviceDespription='" + serviceDespription + '\'' +
            ", monthlyCost=" + monthlyCost +
            ", accounts=" + accounts +
            '}';
    }
}
