package com.solvd.bank.service;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.dao.jdbcMySQLImpl.AccountDAO;
import com.solvd.bank.domain.Account;

import java.io.IOException;
import java.sql.SQLException;

public class AccountService {

    public Account getAccount(long id) {
        IAccountDAO accountDAO = new AccountDAO();

        Account accountToReturn = null;
        try {
            accountToReturn = accountDAO.getEntityById(id);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return accountToReturn;
    }
}
