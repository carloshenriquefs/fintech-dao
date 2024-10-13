package org.example.model;

import java.time.LocalDate;

public class Cards {

    private Long code;
    private Long codeUser;
    private String numberCard;
    private String flag;
    private LocalDate validate;
    private Double balance;

    public Cards() {
    }

    public Cards(Long codeUser, String numberCard, String flag, LocalDate validate, Double balance) {
        this.codeUser = codeUser;
        this.numberCard = numberCard;
        this.flag = flag;
        this.validate = validate;
        this.balance = balance;
    }

    public Cards(Long code, Long codeUser, String numberCard, String flag, LocalDate validate, Double balance) {
        this.code = code;
        this.codeUser = codeUser;
        this.numberCard = numberCard;
        this.flag = flag;
        this.validate = validate;
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

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public LocalDate getValidate() {
        return validate;
    }

    public void setValidate(LocalDate validate) {
        this.validate = validate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
