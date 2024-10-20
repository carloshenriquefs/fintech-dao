package org.example.dao.transactions;

import org.example.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionsDao {
    void insert(Transaction transaction, Long id);
    Transaction getById(Long id);
    List<Transaction> getAll();
    void closeConnection() throws SQLException;
}
