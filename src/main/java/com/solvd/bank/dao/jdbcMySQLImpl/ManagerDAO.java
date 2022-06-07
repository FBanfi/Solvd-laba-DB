package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IManagerDAO;
import com.solvd.bank.domain.Manager;
import com.solvd.bank.exceptions.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO extends AbstractDAO implements IManagerDAO {
    private final static Logger LOGGER = LogManager.getLogger(ManagerDAO.class);
    private final static String SELECT_INFO_BY_MANAGER_ID = "SELECT * FROM Managers LEFT JOIN Phones ON idManagers=?";
    private final static String SELECT_INFO_BY_PHONE_ID = "SELECT * FROM Managers LEFT JOIN Phones ON phone_id=?";

    @Override
    public Manager getEntityById(long id) throws IOException, SQLException, ClassNotFoundException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_INFO_BY_MANAGER_ID);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Manager manager = new Manager();
            rs.next();
            manager.setId(Integer.parseInt(rs.getString("idManagers")));
            manager.setName(rs.getString("name"));
            manager.setLastName(rs.getString("last_name"));

            return manager;
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
    public void saveEntity(Manager entity) {
        throw new UnsupportedOperationException("This method should be implemented");
    }

    @Override
    public void updateEntity(long id, Manager entity) {
        throw new UnsupportedOperationException("This method should be implemented");
    }

    @Override
    public void removeEntity(long id) {
        throw new UnsupportedOperationException("This method should be implemented");
    }

    @Override
    public Manager getManagerByPhoneId(long id) {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            pr = con.prepareStatement(SELECT_INFO_BY_PHONE_ID);
            pr.setLong(1, id);
            rs = pr.executeQuery();
            Manager manager = new Manager();
            rs.next();
            manager.setId(Integer.parseInt(rs.getString("idManagers")));
            manager.setName(rs.getString("name"));
            manager.setLastName(rs.getString("last_name"));

            return manager;
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
