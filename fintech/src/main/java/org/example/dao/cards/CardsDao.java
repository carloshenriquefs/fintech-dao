package org.example.dao.cards;

import org.example.exception.EntityNotFoundException;
import org.example.model.Cards;

import java.sql.SQLException;
import java.util.List;

public interface CardsDao {

    void register(Cards cards) throws SQLException;
    Cards lookUp(long codigo) throws SQLException, EntityNotFoundException;
    List<Cards> list() throws SQLException;
    void update(Cards cards) throws SQLException;
    void remove(long codigo) throws SQLException, EntityNotFoundException;
    void closeConnection() throws SQLException;

}
