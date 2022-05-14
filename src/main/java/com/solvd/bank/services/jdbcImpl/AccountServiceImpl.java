package com.solvd.bank.services.jdbcImpl;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.dao.jdbcMySQLImpl.AccountDAO;
import com.solvd.bank.domain.Account;
import com.solvd.bank.services.IAccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class AccountServiceImpl implements IAccountService {
    private final static Logger LOGGER = LogManager.getLogger(AccountServiceImpl.class);

    @Override
    public Account getAccount(long id) {
        IAccountDAO accountDAO = new AccountDAO();

        Account accountToReturn = null;
        try {
            accountToReturn = accountDAO.getEntityById(id);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            LOGGER.error("There was an error with the service of the account", e);
            throw new RuntimeException(e);
        }

        return accountToReturn;
    }
}
