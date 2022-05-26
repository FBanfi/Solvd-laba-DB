package com.solvd.bank.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Benefit {
    private long id;
    private String benefit;
    private List<Client> clients = new ArrayList<>();

    public Benefit(String benefit) {
        this.benefit = benefit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Benefit other = (Benefit) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.benefit != other.benefit) {
            return false;
        }
        if (this.clients != other.clients) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, benefit);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
}
