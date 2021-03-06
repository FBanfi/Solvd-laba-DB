package com.solvd.bank.dao;

import com.solvd.bank.domain.Account;

public interface IAccountDAO extends IBaseDAO<Account> {
    Account getAccountByAlias(String alias);
}
