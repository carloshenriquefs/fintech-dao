package org.example.dao.cards;

import br.com.fiap.model.Card;

import java.sql.SQLException;
import java.util.List;

public interface CardsDao {

    void insert(Card card, Long id);
    Card getById(Long id);
    List<Card> getAll();
    //    void update(Account accounts, Long id);
//    void remove(Long id);
    void closeConnection() throws SQLException;
}
