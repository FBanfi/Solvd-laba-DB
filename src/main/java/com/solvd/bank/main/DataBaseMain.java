package com.solvd.bank.main;

import com.solvd.bank.domain.*;
import com.solvd.bank.services.mybatis.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;


public class DataBaseMain {
    private static Logger LOGGER = LogManager.getLogger(DataBaseMain.class);

    public static void main(String[] args) {

        //TAKING A RECORD FROM THE DATA BASE WITH CONNECTION POOL:
        //ACCOUNT SERVICE:
        AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
        //    SELECT - by Acc id
        Account newAccount = accountServiceImpl.getAccount(2);
        LOGGER.info("The id of the account with the id 1 is: " + newAccount.getId());
        LOGGER.info("The balance of the account with the id 1 is: " + newAccount.getBalance());
        LOGGER.info("The alias of the account with the id 1 is: " + newAccount.getAlias());
        LOGGER.info("The cbu of the account with the id 1 is: " + newAccount.getCbu());
        //    INSERT
        newAccount.setBalance(123);
        newAccount.setCbu(123);
        newAccount.setAlias("alohomora");
        //accountServiceImpl.saveAccount(newAccount);
        //    DELETE
        accountServiceImpl.deleteAccount(4);
        //    UPDATE
        Account updatedAccount = new Account();
        updatedAccount.setBalance(987987);
        updatedAccount.setCbu(987);
        accountServiceImpl.updateAccountById(1, updatedAccount);

        //CLIENT SERVICE:
        ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
        //     SELECT - by client id
        Client newClient = clientServiceImpl.getClient(1);
        LOGGER.info("The id of the client with the id 1 is: " + newClient.getId());
        LOGGER.info("The name of the account with the id 1 is: " + newClient.getName());
        LOGGER.info("The last name of the account with the id 1 is: " + newClient.getLastName());
        LOGGER.info("The date of birth of the account with the id 1 is: " + newClient.getDateOfBirth());

        //CARD SERVICE:
        CardServiceImpl cardServiceImpl = new CardServiceImpl();
        //    SELECT - by card id
        Card newCard = cardServiceImpl.getCard(1);
        LOGGER.info("The id of the card with the id 1 is: " + newCard.getId());
        LOGGER.info("The last number of the card with the id 1 is: " + newCard.getNumber());
        //    INSERT
        newCard.setNumber(137946825);
        newCard.setAccount(newAccount);
        //cardServiceImpl.saveCard(newCard);
        //    DELETE
        cardServiceImpl.deleteCard(11);
        //    UPDATE
        Card updatedCard = new Card();
        updatedCard.setNumber(111223);
        cardServiceImpl.updateCardById(9, updatedCard);

        //MANAGER SERVICE:
        //     SELECT - by manag id
        ManagerServiceImpl managerServiceImpl = new ManagerServiceImpl();
        Manager newManager = managerServiceImpl.getManager(1);
        LOGGER.info("The id of the card with the id 1 is: " + newManager.getId());
        LOGGER.info("The name of the manager with the id 1 is: " + newManager.getName());
        LOGGER.info("The last name of the manager with the id 1 is: " + newManager.getLastName());

        //PHONE SERVICE:
        //     SELECT - by phone id
        PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();
        Phone newPhone = phoneServiceImpl.getPhone(1);
        LOGGER.info("The id of the phone with the id 1 is: " + newPhone.getId());
        LOGGER.info("The number of the phone with the id 1 is: " + newPhone.getNumber());


        //DES-SERIALIZING A XML FILE WITH JAXB:
        com.solvd.bank.services.jaxbImpl.ManagerServiceImpl jaxbService = new com.solvd.bank.services.jaxbImpl.ManagerServiceImpl();
        Manager serializedManager = jaxbService.unmarshall("C:\\Users\\cocob\\IdeaProjects\\Solvd-laba-DB\\src\\main\\resources\\serialized-manager.xml");
        LOGGER.info("The name of the manager is: " + serializedManager.getName() + " and the date of birth of his 1 client is: " + serializedManager.getClient().remove(1).getDateOfBirth());

        //DES-SERIALIZING A JSON FILE:
        com.solvd.bank.services.jasonService.ClientServiceImpl clientService = new com.solvd.bank.services.jasonService.ClientServiceImpl();
        List<Client> clients = clientService.getDeSerializedClient("C:\\Users\\cocob\\IdeaProjects\\Solvd-laba-DB\\src\\main\\resources\\client.json");
        LOGGER.info("The name of the first client of the jason file is: " + clients.get(1).getName());

    }
}
