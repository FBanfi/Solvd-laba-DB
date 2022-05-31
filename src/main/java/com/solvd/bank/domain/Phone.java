package com.solvd.bank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Phone {
    @JsonProperty("pid")
    private long id;
    @JsonProperty("number")
    private int number;
    private Client client;

    public Phone(int number, Client client) {
        this.number = number;
        this.client = client;
    }

    public Phone() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
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

    @Override
    public String toString() {
        return "Phone{" +
            "id=" + id +
            ", number=" + number +
            ", client=" + client +
            '}';
    }
}
