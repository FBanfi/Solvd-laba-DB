package com.solvd.bank.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name="manager")
public class Manager {
    @XmlAttribute(name="id")
    private long id;

    @XmlElement(name="managerfname")
    private String name;

    @XmlElement(name="managerlname")
    private String lastName;

    @XmlElement(name="phone")
    private Phone phone;

    @XmlElementWrapper(name="clients")
    @XmlElement(name="client", type=Client.class)
    private List<Client> Client = new ArrayList<>();

    @XmlElementWrapper(name="accounts")
    @XmlElement(name="account", type=Account.class)
    private List<Account> accounts = new ArrayList<>();

    @XmlElement(name="username")
    private String username;

    @XmlTransient
    private String password;

    public Manager(String name, String lastName, Phone phone, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public Manager() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Manager other = (Manager) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.name != other.name) {
            return false;
        }
        if (this.lastName != other.lastName) {
            return false;
        }
        if (this.phone != other.phone) {
            return false;
        }
        if (this.username != other.username) {
            return false;
        }
        if (this.password != other.password) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, phone, username, password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public List<com.solvd.bank.domain.Client> getClient() {
        return Client;
    }

    public void setClient(List<com.solvd.bank.domain.Client> client) {
        Client = client;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
