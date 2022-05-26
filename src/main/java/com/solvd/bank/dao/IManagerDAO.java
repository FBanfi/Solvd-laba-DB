package com.solvd.bank.dao;

import com.solvd.bank.domain.Manager;

public interface IManagerDAO extends IBaseDAO<Manager> {
    Manager getManagerByPhoneId(long id);
}
