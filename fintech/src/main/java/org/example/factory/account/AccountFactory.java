package org.example.factory.account;

import org.example.dao.accounts.AccountsDao;
import org.example.dao.accounts.impl.AccountsDaoImpl;
import org.example.factory.users.UsersFactory;
import org.example.model.Accounts;
import org.example.model.builder.AccountsBuilder;

import java.sql.SQLException;

public class AccountFactory {

    public static AccountsDao getAccountDao() throws SQLException {
        return new AccountsDaoImpl();
    }

    public static Accounts createAccounts() {
        return new AccountsBuilder()
                .setCode(1L)
                .setUser(UsersFactory.createUser())
                .setAccountNumber("133")
                .setBalance(2400.0)
                .build();
    }
}
