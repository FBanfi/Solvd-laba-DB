package com.solvd.bank.services;

import com.solvd.bank.domain.Account;

public interface IAccountService {
    Account getAccount(long id);

    void saveAccount(Account account);

    void deleteAccount(long id);

    void updateAccountById(long id, Account accountWithNewValues);
}
