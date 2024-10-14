package org.example.model.builder;

import org.example.model.Accounts;
import org.example.model.User;

public class AccountsBuilder {

    private Long code;
    private User user;
    private String accountNumber;
    private Double balance;

    public AccountsBuilder setCode(Long code) {
        this.code = code;
        return this;
    }

    public AccountsBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public AccountsBuilder setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountsBuilder setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public Accounts build() {
        return new Accounts(code, accountNumber, balance, user);
    }
}
