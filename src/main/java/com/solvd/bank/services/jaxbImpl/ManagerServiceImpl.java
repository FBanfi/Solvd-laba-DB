package com.solvd.bank.services.jaxbImpl;

import com.solvd.bank.domain.Manager;
import com.solvd.bank.services.IJaxbService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ManagerServiceImpl implements IJaxbService {
    private static final Logger LOGGER = LogManager.getLogger(ManagerServiceImpl.class);

    public Manager unmarshall(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Manager.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Manager) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            LOGGER.error("There was an error with jaxb library", e);
        }
        return null;
    }

    public void marshall(Manager manager, String xmlResultPath) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Manager.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(manager, new File(xmlResultPath));
        } catch (JAXBException e) {
            LOGGER.error("There was an error with jaxb library", e);
        }
    }
}
