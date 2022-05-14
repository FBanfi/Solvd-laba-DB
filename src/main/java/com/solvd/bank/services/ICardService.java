package com.solvd.bank.services;

import com.solvd.bank.domain.Card;
import com.solvd.bank.domain.Client;

public interface ICardService {
    Card getCard(long id);
}
