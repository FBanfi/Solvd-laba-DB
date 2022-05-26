package com.solvd.bank.services;

import com.solvd.bank.domain.Manager;

public interface IJaxbService {
    Manager unmarshall(String xmFilePath);
}
