package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.ICardDAO;
import com.solvd.bank.domain.Card;
import com.solvd.bank.exceptions.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO extends AbstractDAO implements ICardDAO {
    private final static Logger LOGGER = LogManager.getLogger(CardDAO.class);
    private final static String SELECT_INFO_BY_ID = "SELECT * FROM Cards JOIN Accounts WHERE idCards=?";
    private final static String SELECT_INFO_BY_ACCOUNT_ID = "SELECT * FROM Cards JOIN Accounts WHERE account_id=?";
    private final static String DELETE_CARD_BY_ID = "DELETE FROM Cards WHERE idCards=?";
    private final static String UPDATE_CARD_BY_ID = "UPDATE Cards SET number=? WHERE idCards=?";

    @Override
    public Card getEntityById(long id) throws SQLException, ClassNotFoundException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_INFO_BY_ID);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Card card = new Card();
            rs.next();
            card.setId(Integer.parseInt(rs.getString("idCards")));
            card.setNumber(Double.parseDouble(rs.getString("number")));

            return card;
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
    public void saveEntity(Card entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        Double number = entity.getNumber();
        Long accountID = entity.getAccount().getId();
        try {
            String query = "INSERT INTO Cards (number,account_id) VALUES (" + number.toString() + "," + accountID.toString() + ")";
            pr = con.prepareStatement(query);
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
    public void updateEntity(long id, Card entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(UPDATE_CARD_BY_ID);
            pr.setDouble(1, entity.getNumber());
            pr.setLong(2, id);
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
            pr = con.prepareStatement(DELETE_CARD_BY_ID);
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
    public Card getCardByAccountId(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_INFO_BY_ACCOUNT_ID);
            pr.setDouble(1, id);
            rs = pr.executeQuery();
            Card card = new Card();
            rs.next();
            card.setId(Integer.parseInt(rs.getString("idCards")));
            card.setNumber(Double.parseDouble(rs.getString("number")));

            return card;
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
