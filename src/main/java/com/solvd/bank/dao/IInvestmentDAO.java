package com.solvd.bank.dao;

import com.solvd.bank.domain.Investment;

public interface IInvestmentDAO extends IBaseDAO<Investment> {
    void getInvestmentByAccountId();
}
