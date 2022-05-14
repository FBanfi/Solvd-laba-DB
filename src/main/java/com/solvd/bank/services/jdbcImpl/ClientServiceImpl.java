package com.solvd.bank.services.jdbcImpl;

import com.solvd.bank.dao.IClientDAO;
import com.solvd.bank.dao.jdbcMySQLImpl.ClientDAO;
import com.solvd.bank.domain.Client;
import com.solvd.bank.services.IClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class ClientServiceImpl implements IClientService {
    private final static Logger LOGGER = LogManager.getLogger(ClientServiceImpl.class);

    @Override
    public Client getClient(long id) {
        IClientDAO clientDAO = new ClientDAO();

        Client clientToReturn = null;
        try {
            clientToReturn = clientDAO.getEntityById(id);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            LOGGER.error("There was an error with the service of the client", e);
            throw new RuntimeException(e);
        }

        return clientToReturn;
    }
}
