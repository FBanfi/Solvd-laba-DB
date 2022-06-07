package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IAccountDAO;
import com.solvd.bank.domain.Account;
import com.solvd.bank.domain.Card;
import com.solvd.bank.exceptions.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class AccountDAO extends AbstractDAO implements IAccountDAO {
    private final static Logger LOGGER = LogManager.getLogger(AccountDAO.class);
    private final static String SELECT_BALANCE_BY_ACCOUNT_ID = "SELECT * FROM Accounts WHERE idAccounts=?";
    private final static String SELECT_BALANCE_BY_USER_ID = "SELECT * FROM Accounts WHERE alias=?";
    private final static String DELETE_ACCOUNT_BY_ID = "DELETE FROM Accounts WHERE idAccounts=?";
    private final static String UPDATE_ACCOUNT_BY_ID = "UPDATE Accounts SET balance=?, cbu=? WHERE idAccounts=?";
    private final static String INSERT_ACCOUNT = "INSERT INTO Cards (balance,cbu,alias) VALUES (?,?,?)";

    @Override
    public Account getEntityById(long id) {
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
            throw new DAOException("There was a problem while doing the statement" + e);
        }
        finally {
            returnConnection(con);
            try {
                if (pr != null)
                    pr.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new DAOException("Exception while closing the statement" + e);
            }
        }
    }

    @Override
    public void saveEntity(Account entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(INSERT_ACCOUNT);
            pr.setDouble(1, entity.getBalance());
            pr.setDouble(2, entity.getCbu());
            pr.setString(3, entity.getAlias());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("There was a problem while doing the statement" + e);
        }
        finally {
            returnConnection(con);
            try {
                if (pr != null)
                    pr.close();
            } catch (SQLException e) {
                throw new DAOException("Exception while closing the statement" + e);
            }
        }
    }

    @Override
    public void updateEntity(long id, Account entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(UPDATE_ACCOUNT_BY_ID);
            pr.setDouble(1, entity.getBalance());
            pr.setDouble(2, entity.getCbu());
            pr.setLong(3, id);
            pr.execute();
        } catch (SQLException e) {
            throw new DAOException("There was a problem while doing the statement" + e);
        }
        finally {
            returnConnection(con);
            try {
                if (pr != null)
                    pr.close();
            } catch (SQLException e) {
                throw new DAOException("Exception while closing the statement" + e);
            }
        }
    }

    @Override
    public void removeEntity(long id) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(DELETE_ACCOUNT_BY_ID);
            pr.setLong(1, id);
            pr.execute();
        } catch (SQLException e) {
            throw new DAOException("There was a problem while doing the statement" + e);
        }
        finally {
            returnConnection(con);
            try {
                if (pr != null)
                    pr.close();
            } catch (SQLException e) {
                throw new DAOException("Exception while closing the statement" + e);
            }
        }
    }

    @Override
    public Account getAccountByAlias(String alias) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_BALANCE_BY_USER_ID);
            pr.setString(1, alias);
            rs = pr.executeQuery();
            Account account = new Account();
            rs.next();
            account.setId(Integer.parseInt(rs.getString("idAccounts")));
            account.setBalance(Double.parseDouble(rs.getString("balance")));
            account.setAlias(rs.getString("alias"));
            account.setCbu(Double.parseDouble(rs.getString("cbu")));

            return account;
        } catch (SQLException e) {
            throw new DAOException("There was a problem while doing the statement" + e);
        }
        finally {
            returnConnection(con);
            try {
                if (pr != null)
                    pr.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new DAOException("Exception while closing the statement" + e);
            }
        }
    }
}
