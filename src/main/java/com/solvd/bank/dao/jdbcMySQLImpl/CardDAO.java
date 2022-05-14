package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.ICardDAO;
import com.solvd.bank.domain.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO extends AbstractDAO implements ICardDAO {
    private final static Logger LOGGER = LogManager.getLogger(CardDAO.class);
    private final static String SELECT_INFO_BY_ACCOUNT_ID = "SELECT * FROM Cards JOIN Accounts WHERE account_id=?";

    @Override
    public Card getEntityById(long id) throws SQLException, ClassNotFoundException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_INFO_BY_ACCOUNT_ID);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Card card = new Card();
            rs.next();
            card.setId(Integer.parseInt(rs.getString("idCards")));
            card.setNumber(Double.parseDouble(rs.getString("number")));

            return card;
        } catch (SQLException e) {
            LOGGER.error("There was a problem while doing the statement");
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

        return null;
    }

    @Override
    public void saveEntity(Card entity) {

    }

    @Override
    public void updateEntity(Card entity) {

    }

    @Override
    public void removeEntity(long id) {

    }
}
