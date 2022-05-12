package com.solvd.bank.domain.jaxb;

import com.solvd.bank.domain.Account;
import com.solvd.bank.domain.Client;
import com.solvd.bank.domain.Phone;

import javax.xml.bind.annotation.*;
import java.util.List;

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
    private List<Client> Client;

    @XmlElementWrapper(name="accounts")
    @XmlElement(name="account", type=Account.class)
    private List<Account> accounts;

    @XmlElement(name="username")
    private String username;

    @XmlTransient
    private String password;

    public String getName() {
        return this.name;
    }
}
