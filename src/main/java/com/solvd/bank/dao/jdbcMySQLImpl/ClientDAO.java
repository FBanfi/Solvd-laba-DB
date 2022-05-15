package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IClientDAO;
import com.solvd.bank.domain.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends AbstractDAO implements IClientDAO {
    private final static Logger LOGGER = LogManager.getLogger(ClientDAO.class);
    private final static String SELECT_NAME_BY_CLIENT_ID = "SELECT * FROM Clients JOIN Managers JOIN Accounts ON account_id=?";

    @Override
    public Client getEntityById(long id) throws SQLException, ClassNotFoundException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_NAME_BY_CLIENT_ID);
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
    public void saveEntity(Client entity) {

    }

    @Override
    public void updateEntity(long id, Client entity) {

    }

    @Override
    public void removeEntity(long id) {

    }
}
