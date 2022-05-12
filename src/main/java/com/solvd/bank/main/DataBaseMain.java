package com.solvd.bank.main;

import com.solvd.bank.domain.Account;
import com.solvd.bank.domain.jaxb.Manager;
import com.solvd.bank.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class DataBaseMain {
    private static Logger LOGGER = LogManager.getLogger(DataBaseMain.class);

    public static void main(String[] args) {

        //TAKING A RECORD FROM THE DATA BASE WITH CONNECTION POOL:
        AccountService accountService = new AccountService();
        Account newAccount = accountService.getAccount(1);
        LOGGER.info("The balance of the account with the id 1 is: " + newAccount.getBalance());

        //DES-SERIALIZING A XML FILE WITH JAXB:
        File xmlFile = new File("C:\\Users\\cocob\\IdeaProjects\\Solvd-laba-DB\\src\\main\\resources\\serialized-manager.xml");
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Manager.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Manager manager = (Manager) unmarshaller.unmarshal(xmlFile);
            LOGGER.info("The name of the manager is: " + manager.getName());
        } catch (JAXBException e) {
            LOGGER.error("There was an error with jaxb library", e);
        }
    }
}
