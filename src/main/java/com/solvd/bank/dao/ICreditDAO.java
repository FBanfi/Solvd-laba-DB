package com.solvd.bank.dao;

import com.solvd.bank.domain.Credit;

public interface ICreditDAO extends IBaseDAO<Credit> {
    void getCreditByAccountId();
}
