package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.domain.Account;
import com.solvd.bank.utils.connectionPool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class AccountDAO implements IAccountDAO {
    private static Logger LOGGER = LogManager.getLogger(AccountDAO.class);

    @Override
    public void getAccountByClientId() {
        //TODO
    }

    @Override
    public Account getEntityById(long id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        PreparedStatement pr = null;
        ResultSet rs = null;
        try (Connection con = ConnectionPool.getInstance().getConnection()) {
            pr = con.prepareStatement("SELECT balance FROM Accounts WHERE idAccounts=?");
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Account account = new Account();
            rs.next();
            account.setBalance(Double.parseDouble(rs.getString("balance")));

            pr.close();
            rs.close();
            return account;
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
        }
        finally {
            pr.close();
            rs.close();
        }

        return null;
    }

    @Override
    public void saveEntity(Account entity) {

    }

    @Override
    public void updateEntity(Account entity) {

    }

    @Override
    public void removeEntity(long id) {

    }
}
