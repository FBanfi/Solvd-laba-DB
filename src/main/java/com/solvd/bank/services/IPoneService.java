package com.solvd.bank.services;

import com.solvd.bank.domain.Phone;

public interface IPoneService {
    Phone getPhone(long id);
    Phone getPhoneByClientId(long id);
}
