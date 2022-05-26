package com.solvd.bank.dao;

import com.solvd.bank.domain.Card;

public interface ICardDAO extends IBaseDAO<Card> {
    Card getCardByAccountId(long id);
}
