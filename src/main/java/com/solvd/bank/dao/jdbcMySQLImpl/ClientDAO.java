package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IClientDAO;
import com.solvd.bank.domain.Card;
import com.solvd.bank.domain.Client;
import com.solvd.bank.exceptions.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends AbstractDAO implements IClientDAO {
    private final static Logger LOGGER = LogManager.getLogger(ClientDAO.class);
    private final static String SELECT_CLIENT_BY_ID = "SELECT * FROM Clients JOIN Managers JOIN Accounts ON account_id=?";
    private final static String SELECT_CLIENT_BY_LAST_NAME = "SELECT * FROM Clients WHERE last_name=?";
    private final static String DELETE_CLIENT_BY_ID = "DELETE FROM Clients WHERE idClients=?";
    private final static String UPDATE_CLIENT_BY_ID = "UPDATE Clients SET name=?, last_name=?, date_of_birth= ?, email=? WHERE idClients=?";

    @Override
    public Client getEntityById(long id) throws SQLException, ClassNotFoundException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_CLIENT_BY_ID);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Client client = new Client();
            rs.next();
            client.setId(Integer.parseInt(rs.getString("idClients")));
            client.setName(rs.getString("name"));
            client.setLastName(rs.getString("last_name"));
            client.setDateOfBirth(rs.getString("date_of_birth"));

            return client;
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
    public void saveEntity(Client entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        String name = entity.getName();
        String lastName = entity.getLastName();
        String dateOfBirth = entity.getDateOfBirth();
        String email = entity.getEmail();
        Long accountID = entity.getAccount().getId();
        try {
            String query = "INSERT INTO Cards (name,last_name,date_of_birth,email,account_id) VALUES (" + name + "," + lastName + dateOfBirth + email + accountID.toString() + ")";
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
    public void updateEntity(long id, Client entity) {
        PreparedStatement pr = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(UPDATE_CLIENT_BY_ID);
            pr.setString(1, entity.getEmail());
            pr.setString(2, entity.getName());
            pr.setString(3, entity.getLastName());
            pr.setString(4, entity.getDateOfBirth());
            pr.setLong(5, id);
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
            pr = con.prepareStatement(DELETE_CLIENT_BY_ID);
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
    public Client getClientByLastName(String lastName) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_CLIENT_BY_LAST_NAME);
            pr.setString(1, lastName);
            rs = pr.executeQuery();
            Client client = new Client();
            rs.next();
            client.setId(Integer.parseInt(rs.getString("idClients")));
            client.setName(rs.getString("name"));
            client.setLastName(rs.getString("last_name"));
            client.setDateOfBirth(rs.getString("date_of_birth"));

            return client;
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
