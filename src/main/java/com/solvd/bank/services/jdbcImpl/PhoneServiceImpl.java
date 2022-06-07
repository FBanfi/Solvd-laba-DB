package com.solvd.bank.services.jdbcImpl;

import com.solvd.bank.dao.IPhoneDAO;
import com.solvd.bank.dao.jdbcMySQLImpl.PhoneDAO;
import com.solvd.bank.domain.Phone;
import com.solvd.bank.exceptions.DAOException;
import com.solvd.bank.services.IPoneService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class PhoneServiceImpl implements IPoneService {
    private final static Logger LOGGER = LogManager.getLogger(PhoneServiceImpl.class);

    @Override
    public Phone getPhone(long id) {
        IPhoneDAO phoneDAO = new PhoneDAO();

        Phone phoneToReturn = null;
        try {
            phoneToReturn = phoneDAO.getEntityById(id);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new DAOException("There was an error with the service of the phone" + e);
        }

        return phoneToReturn;
    }

    @Override
    public Phone getPhoneByClientId(long id) {
        IPhoneDAO phoneDAO = new PhoneDAO();
        return phoneDAO.getPhoneByClientId(id);
    }
}
