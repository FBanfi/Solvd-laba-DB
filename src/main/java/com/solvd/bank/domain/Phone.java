package com.solvd.bank.domain;

import java.util.Objects;

public class Phone {
    private long id;
    private double number;
    private Client client;

    public Phone(double number, Client client) {
        this.number = number;
        this.client = client;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Phone other = (Phone) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        if (this.client != other.client) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, client);
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
