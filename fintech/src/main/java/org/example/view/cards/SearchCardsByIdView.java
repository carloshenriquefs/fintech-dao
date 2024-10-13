package org.example.view.cards;

import org.example.dao.cards.CardsDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Cards;

import java.sql.SQLException;

import static org.example.constants.Constants.CODE_NOT_EXIST;

public class SearchCardsByIdView {

    public static void main(String[] args) {
        try {
            CardsDao dao = new CardsDao();
            Cards card = dao.pesquisar(3);
            System.out.println(card.getCodeUser() + " - " + card.getNumberCard() + ", " + card.getFlag() + ", " + card.getValidate());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(CODE_NOT_EXIST);
        }
    }
}
