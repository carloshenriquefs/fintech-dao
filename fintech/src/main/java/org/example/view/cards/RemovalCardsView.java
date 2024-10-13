package org.example.view.cards;

import org.example.dao.cards.CardsDao;
import org.example.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

import static org.example.constants.Constants.CARDS_NOT_FOUND;
import static org.example.constants.Constants.CARDS_REMOVED;

public class RemovalCardsView {

    public static void main(String[] args) {
        try {
            CardsDao dao = new CardsDao();
            dao.remover(3);
            dao.fecharConexao();
            System.out.println(CARDS_REMOVED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(CARDS_NOT_FOUND);
        }
    }
}
