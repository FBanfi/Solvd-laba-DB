package com.solvd.bank.services;

import com.solvd.bank.domain.Account;
import com.solvd.bank.domain.Client;

public interface IClientService {
    Client getClient(long id);

    void saveClient(Client client);

    void deleteClient(long id);

    void updateClientById(long id, Client client);

    Client getClientByLastName(String lastName);
}
