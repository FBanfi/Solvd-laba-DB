package com.solvd.bank.dao;

import com.solvd.bank.domain.Debt;

public interface IDebtDAO extends IBaseDAO<Debt> {
    void getDebtByAccountId();
}
