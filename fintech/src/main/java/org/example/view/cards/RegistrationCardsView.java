package org.example.view.cards;

import org.example.dao.cards.CardsDao;
import org.example.model.Cards;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.example.constants.Constants.CARDS_REGISTERED;

public class RegistrationCardsView {

    public static void main(String[] args) {
        try {
            CardsDao dao = new CardsDao();
            Cards statistics = new Cards(3L, "142", "258963", LocalDate.of(2022, 4, 3), 2000.0);
            dao.cadastrar(statistics);
            dao.fecharConexao();
            System.out.println(CARDS_REGISTERED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
