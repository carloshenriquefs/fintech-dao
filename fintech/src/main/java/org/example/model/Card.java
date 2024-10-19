package org.example.model;

import java.time.LocalDate;

public class Card {

    private Long code;
    private Long userId;
    private String numberCard;
    private String flag;
    private LocalDate validate;
    private Double balance;

    public Card(Long userId, String numberCard, String flag, LocalDate validate, Double balance) {
        this.userId = userId;
        this.numberCard = numberCard;
        this.flag = flag;
        this.validate = validate;
        this.balance = balance;
    }

    public Card(Long code, Long userId, String numberCard, String flag, LocalDate validate, Double balance) {
        this.code = code;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

