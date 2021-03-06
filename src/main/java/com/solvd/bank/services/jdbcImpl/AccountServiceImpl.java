package com.solvd.bank.services.jdbcImpl;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.dao.jdbcMySQLImpl.AccountDAO;
import com.solvd.bank.domain.Account;
import com.solvd.bank.exceptions.ServiceException;
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
            throw new ServiceException("There was an error with the service of the account" + e);
        }

        return accountToReturn;
    }

    @Override
    public void saveAccount(Account account) {
        IAccountDAO accountDAO = new AccountDAO();
        accountDAO.saveEntity(account);
    }


    @Override
    public void deleteAccount(long id) {
        IAccountDAO accountDAO = new AccountDAO();
        accountDAO.removeEntity(id);
    }

    @Override
    public void updateAccountById(long id, Account accountWithNewValues) {
        IAccountDAO accountDAO = new AccountDAO();
        accountDAO.updateEntity(id,accountWithNewValues);
    }

    @Override
    public Account getAccountByAlias(String alias) {
        IAccountDAO accountDAO = new AccountDAO();
        return accountDAO.getAccountByAlias(alias);
    }
}
