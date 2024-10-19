package org.example.factory.cards;

import org.example.dao.cards.CardsDao;
import org.example.dao.cards.impl.CardsDaoImpl;
import org.example.model.Card;
import org.example.model.builder.CardsBuilder;

import java.sql.SQLException;
import java.time.LocalDate;

public class CardsFactory {

    public static CardsDao getCardsDao() throws SQLException {
        return new CardsDaoImpl();
    }

    public static Card createCards() {
        return new CardsBuilder()
                .setCode(1L)
                .setNumberCard("12036")
                .setFlag("0123")
                .setValidate(LocalDate.of(2015, 3, 14))
                .setBalance(2050.8)
                .build();
    }
}

