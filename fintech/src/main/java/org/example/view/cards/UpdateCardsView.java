package org.example.view.cards;

import org.example.dao.cards.CardsDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Cards;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.example.constants.Constants.CARDS_NOT_FOUND;
import static org.example.constants.Constants.CARDS_UPDATED;

public class UpdateCardsView {

    public static void main(String[] args) {
        try {
            CardsDao dao = new CardsDao();
            Cards cards = dao.pesquisar(3);
            cards.setCodeUser(3L);
            cards.setNumberCard("3659235");
            cards.setFlag("120");
            cards.setValidate(LocalDate.of(2020, 2, 10));
            cards.setBalance(200.0);
            dao.atualizar(cards);
            dao.fecharConexao();
            System.out.println(CARDS_UPDATED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(CARDS_NOT_FOUND);
        }
    }
}
