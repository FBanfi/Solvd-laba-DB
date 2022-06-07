package com.solvd.bank.services.jdbcImpl;

import com.solvd.bank.dao.IManagerDAO;
import com.solvd.bank.dao.jdbcMySQLImpl.ManagerDAO;
import com.solvd.bank.domain.Manager;
import com.solvd.bank.exceptions.ServiceException;
import com.solvd.bank.services.IManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class ManagerServiceImpl implements IManagerService {
    private final static Logger LOGGER = LogManager.getLogger(ManagerServiceImpl.class);

    @Override
    public Manager getManager(long id) {
        IManagerDAO managerDAO = new ManagerDAO();

        Manager managerToReturn = null;
        try {
            managerToReturn = managerDAO.getEntityById(id);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new ServiceException("There was an error with the service of the manager" + e);
        }

        return managerToReturn;
    }

    @Override
    public Manager getManagerByPhoneId(long id) {
        IManagerDAO managerDAO = new ManagerDAO();
        return managerDAO.getManagerByPhoneId(id);
    }
}
