package com.solvd.bank.dao;

import com.solvd.bank.domain.Account;

public interface IAccountDAO extends IBaseDAO<Account> {
    void getAccountByClientId();
}
