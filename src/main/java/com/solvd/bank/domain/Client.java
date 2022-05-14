package com.solvd.bank.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Client {
    private long id;
    private String name;
    private String lastName;
    private String dateOfBirth;
    private double document;
    private String email;
    private Phone phone;
    private Account account;

    public Client(String name, String lastName, String dateOfBirth, double document,
                  String email, Phone phone, Account account) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.document = document;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    public Client() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.name != other.name) {
            return false;
        }
        if (this.lastName != other.lastName) {
            return false;
        }
        if (this.dateOfBirth != other.dateOfBirth) {
            return false;
        }
        if (this.document != other.document) {
            return false;
        }
        if (this.email != other.email) {
            return false;
        }
        if (this.phone != other.phone) {
            return false;
        }
        if (this.account != other.account) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, dateOfBirth, document, email, phone, account);
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getDocument() {
        return document;
    }

    public void setDocument(double document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
