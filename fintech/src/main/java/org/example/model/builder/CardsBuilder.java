package org.example.model.builder;

import org.example.model.Cards;

import java.time.LocalDate;

public class CardsBuilder {

    private Long code;
    private Long codeUser;
    private String numberCard;
    private String flag;
    private LocalDate validate;
    private Double balance;

    public CardsBuilder setCode(Long code) {
        this.code = code;
        return this;
    }

    public CardsBuilder setCodeUser(Long codeUser) {
        this.codeUser = codeUser;
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

    public Cards build() {
        return new Cards(codeUser, numberCard, flag, validate, balance);
    }
}
