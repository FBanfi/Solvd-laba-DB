package com.solvd.bank.main;

import com.solvd.bank.domain.Account;
import com.solvd.bank.domain.Manager;
import com.solvd.bank.services.IJaxbService;
import com.solvd.bank.services.jaxbImpl.JaxbServiceImpl;
import com.solvd.bank.services.jdbcImpl.AccountServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataBaseMain {
    private static Logger LOGGER = LogManager.getLogger(DataBaseMain.class);

    public static void main(String[] args) {

        //TAKING A RECORD FROM THE DATA BASE WITH CONNECTION POOL:
        AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
        Account newAccount = accountServiceImpl.getAccount(1);
        LOGGER.info("The id of the account with the id 1 is: " + newAccount.getId());
        LOGGER.info("The balance of the account with the id 1 is: " + newAccount.getBalance());
        LOGGER.info("The alias of the account with the id 1 is: " + newAccount.getAlias());
        LOGGER.info("The cbu of the account with the id 1 is: " + newAccount.getCbu());




        /*
        //DES-SERIALIZING A XML FILE WITH JAXB:
        IJaxbService jaxbService = new JaxbServiceImpl();
        Manager serializedManager = (Manager) jaxbService.unmarshall("C:\\Users\\cocob\\IdeaProjects\\Solvd-laba-DB\\src\\main\\resources\\serialized-manager.xml");
        LOGGER.info("AAAAAAAAAAAAAAAAAAAAAAAAAA");
        LOGGER.info("The name of the manager is: " + serializedManager.getName());
         */
    }
}
