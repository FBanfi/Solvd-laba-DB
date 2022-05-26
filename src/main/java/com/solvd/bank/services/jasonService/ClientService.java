package com.solvd.bank.services.jasonService;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.bank.domain.Client;
import com.solvd.bank.services.IJasonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ClientService implements IJasonService {
    private static final Logger LOGGER = LogManager.getLogger(ClientService.class);

    public List<Client> getDeSerializedClient(String path) {
        ObjectMapper om = new ObjectMapper();
        try {
            JavaType type = om.getTypeFactory().constructCollectionType(List.class, Client.class);
            List<Client> clients;
            return om.readValue(new File(path), type);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.info("There was an error while des serializing the client" + e);
        }

        return null;
    }
}
