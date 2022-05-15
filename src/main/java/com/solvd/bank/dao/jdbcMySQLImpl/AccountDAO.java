package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.domain.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class AccountDAO extends AbstractDAO implements IAccountDAO {
    private final static Logger LOGGER = LogManager.getLogger(AccountDAO.class);
    private final static String SELECT_BALANCE_BY_ACCOUNT_ID = "SELECT * FROM Accounts WHERE idAccounts=?";

    @Override
    public Account getEntityById(long id) throws SQLException, ClassNotFoundException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_BALANCE_BY_ACCOUNT_ID);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Account account = new Account();
            rs.next();
            account.setId(Integer.parseInt(rs.getString("idAccounts")));
            account.setBalance(Double.parseDouble(rs.getString("balance")));
            account.setAlias(rs.getString("alias"));
            account.setCbu(Double.parseDouble(rs.getString("cbu")));

            return account;
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
            throw new RuntimeException(e);
        }
        finally {
            returnConnection(con);
            try {
                if (pr != null)
                    pr.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                LOGGER.error("Exception while closing the statement", e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void saveEntity(Account entity) {

    }

    @Override
    public void updateEntity(long id, Account entity) {

    }

    @Override
    public void removeEntity(long id) {

    }
}
