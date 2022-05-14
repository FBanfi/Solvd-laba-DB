package com.solvd.bank.services.jdbcImpl;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.dao.jdbcMySQLImpl.AccountDAO;
import com.solvd.bank.domain.Account;
import com.solvd.bank.services.IAccountService;

import java.io.IOException;
import java.sql.SQLException;

public class AccountServiceImpl implements IAccountService {

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
