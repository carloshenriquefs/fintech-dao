package org.example.model.builder;

import org.example.model.Account;

public class AccountBuilder {

    private Long code;
    private Long userId;
    private String accountNumber;
    private Double balance;

    public void setCode(Long code) {
        this.code = code;
    }

    public AccountBuilder setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public AccountBuilder setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountBuilder setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public Account build() {
        return new Account(code, accountNumber, balance, userId);
    }
}
