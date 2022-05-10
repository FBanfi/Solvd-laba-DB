package com.solvd.bank.main;

import com.solvd.bank.domain.Account;
import com.solvd.bank.service.AccountService;

public class DataBaseMain {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();

        Account newAccount = accountService.getAccount(1);

        System.out.println(newAccount.getBalance());
    }
}
