package org.example.view.cards;

import org.example.dao.cards.CardsDao;
import org.example.model.Cards;

import java.sql.SQLException;
import java.util.List;

public class ListingCardsView {

    public static void main(String[] args) {
        try {
            CardsDao dao = new CardsDao();
            List<Cards> cards = dao.listar();
            for (Cards card : cards) {
                System.out.println(card.getCodeUser() + " - " + card.getNumberCard() + ", " + card.getFlag() + ", " + card.getValidate());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
