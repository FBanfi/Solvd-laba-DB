package com.solvd.bank.dao;

import com.solvd.bank.domain.Subscription;

public interface ISubscriptionDAO extends IBaseDAO<Subscription> {
    void getAccountByAccountId();
}
