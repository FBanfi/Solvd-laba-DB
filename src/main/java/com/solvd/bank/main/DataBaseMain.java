package com.solvd.bank.main;

import com.solvd.bank.domain.*;
import com.solvd.bank.services.jdbcImpl.*;
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

        ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
        Client newClient = clientServiceImpl.getClient(1);
        LOGGER.info("The id of the client with the id 1 is: " + newClient.getId());
        LOGGER.info("The name of the account with the id 1 is: " + newClient.getName());
        LOGGER.info("The last name of the account with the id 1 is: " + newClient.getLastName());
        LOGGER.info("The date of birth of the account with the id 1 is: " + newClient.getDateOfBirth());

        CardServiceImpl cardServiceImpl = new CardServiceImpl();
        Card newCard = cardServiceImpl.getCard(1);
        LOGGER.info("The id of the card with the id 1 is: " + newCard.getId());
        LOGGER.info("The last number of the card with the id 1 is: " + newCard.getNumber());

        ManagerServiceImpl managerServiceImpl = new ManagerServiceImpl();
        Manager newManager = managerServiceImpl.getManager(1);
        LOGGER.info("The id of the card with the id 1 is: " + newManager.getId());
        LOGGER.info("The name of the manager with the id 1 is: " + newManager.getName());
        LOGGER.info("The last name of the manager with the id 1 is: " + newManager.getLastName());

        PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();
        Phone newPhone = phoneServiceImpl.getPhone(1);
        LOGGER.info("The id of the phone with the id 1 is: " + newPhone.getId());
        LOGGER.info("The number of the phone with the id 1 is: " + newPhone.getNumber());

        /*
        //DES-SERIALIZING A XML FILE WITH JAXB:
        IJaxbService jaxbService = new JaxbServiceImpl();
        Manager serializedManager = (Manager) jaxbService.unmarshall("C:\\Users\\cocob\\IdeaProjects\\Solvd-laba-DB\\src\\main\\resources\\serialized-manager.xml");
        LOGGER.info("AAAAAAAAAAAAAAAAAAAAAAAAAA");
        LOGGER.info("The name of the manager is: " + serializedManager.getName());
         */
    }
}
