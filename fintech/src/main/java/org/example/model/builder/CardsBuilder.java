package org.example.model.builder;

import org.example.model.Card;

import java.time.LocalDate;

public class CardsBuilder {

    private Long code;
    private Long userId;
    private String numberCard;
    private String flag;
    private LocalDate validate;
    private Double balance;

    public CardsBuilder setCode(Long code) {
        this.code = code;
        return this;
    }

    public CardsBuilder setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public CardsBuilder setNumberCard(String numberCard) {
        this.numberCard = numberCard;
        return this;
    }

    public CardsBuilder setFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public CardsBuilder setValidate(LocalDate validate) {
        this.validate = validate;
        return this;
    }

    public CardsBuilder setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public Card build() {
        return new Card(userId, numberCard, flag, validate, balance);
    }
}
