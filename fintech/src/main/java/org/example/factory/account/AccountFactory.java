package org.example.factory.account;

import org.example.dao.accounts.AccountsDao;
import org.example.dao.accounts.impl.AccountsDaoImpl;
import org.example.model.Account;
import org.example.model.builder.AccountBuilder;

import java.sql.SQLException;

public class AccountFactory {

    public static AccountsDao getAccountDao() throws SQLException {
        return new AccountsDaoImpl();
    }

    public static Account createAccounts() {
        return new AccountBuilder()
                .setUserId(2L)
                .setAccountNumber("133")
                .setBalance(2400.0)
                .build();
    }
}
