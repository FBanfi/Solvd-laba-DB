package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IPhoneDAO;
import com.solvd.bank.domain.Phone;
import com.solvd.bank.exceptions.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneDAO extends AbstractDAO implements IPhoneDAO {
    private final static Logger LOGGER = LogManager.getLogger(PhoneDAO.class);
    private final static String SELECT_INFO_BY_PHONE_ID = "SELECT * FROM Phones WHERE idPhones=?";
    private final static String SELECT_INFO_BY_CLIENT_ID = "SELECT * FROM Phones WHERE client_id=?";

    @Override
    public Phone getEntityById(long id) throws IOException, SQLException, ClassNotFoundException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_INFO_BY_PHONE_ID);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Phone phone = new Phone();
            rs.next();
            phone.setId(Integer.parseInt(rs.getString("idPhones")));
            phone.setNumber(Integer.parseInt(rs.getString("number")));

            return phone;
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
    public void saveEntity(Phone entity) {
        throw new UnsupportedOperationException("This method should be implemented");
    }

    @Override
    public void updateEntity(long id, Phone entity) {
        throw new UnsupportedOperationException("This method should be implemented");
    }

    @Override
    public void removeEntity(long id) {
        throw new UnsupportedOperationException("This method should be implemented");
    }

    @Override
    public Phone getPhoneByClientId(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_INFO_BY_CLIENT_ID);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Phone phone = new Phone();
            rs.next();
            phone.setId(Integer.parseInt(rs.getString("idPhones")));
            phone.setNumber(Integer.parseInt(rs.getString("number")));

            return phone;
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
