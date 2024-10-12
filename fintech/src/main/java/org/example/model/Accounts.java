package org.example.model;

public class Accounts {

    private Long code;
    private Long codeUser;
    private String accountNumber;
    private Double balance;

    public Accounts() {
    }

    public Accounts(Long codeUser, String accountNumber, Double balance) {
        this.codeUser = codeUser;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Accounts(Long code, Long codeUser, String accountNumber, Double balance) {
        this.code = code;
        this.codeUser = codeUser;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(Long codeUser) {
        this.codeUser = codeUser;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
