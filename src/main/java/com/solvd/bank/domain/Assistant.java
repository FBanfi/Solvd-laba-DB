package com.solvd.bank.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Assistant {
    private long id;
    private String name;
    private String lastName;
    private List<Client> clientsHelped = new ArrayList<>();

    public Assistant(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Assistant other = (Assistant) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.name != other.name) {
            return false;
        }
        if (this.lastName != other.lastName) {
            return false;
        }
        if (this.clientsHelped != other.clientsHelped) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName);
    }

    @Override
    public String toString() {
        return "Assistant{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", clientsHelped=" + clientsHelped +
            '}';
    }
}
