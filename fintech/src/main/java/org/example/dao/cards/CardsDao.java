package org.example.dao.cards;

import org.example.model.Card;

import java.sql.SQLException;
import java.util.List;

public interface CardsDao {

    void insert(Card card, Long id);
    Card getById(Long id);
    List<Card> getAll();
    void closeConnection() throws SQLException;
}
