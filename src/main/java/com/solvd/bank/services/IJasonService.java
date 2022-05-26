package com.solvd.bank.services;

import com.solvd.bank.domain.Client;

import java.util.List;

public interface IJasonService {
    List<Client> getDeSerializedClient(String path);
}
