package org.example.dao.transactions;

import org.example.exception.EntityNotFoundException;
import org.example.model.Transactions;

import java.util.List;
import java.sql.SQLException;

public interface TransactionsDao {

    void register(Transactions transactions) throws SQLException;
    Transactions lookUp(long coidgo) throws SQLException, EntityNotFoundException;
    List<Transactions> list() throws SQLException;
    void update(Transactions transactions) throws SQLException;
    void remove(long codigo) throws SQLException, EntityNotFoundException;
    void closeConnection() throws SQLException;

}
