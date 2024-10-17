package org.example.dao.transactions;

import br.com.fiap.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionsDao {
    void insert(Transaction transaction, Long id);
    Transaction getById(Long id);
    List<Transaction> getAll();
    //    void update(Account accounts, Long id);
//    void remove(Long id);
    void closeConnection() throws SQLException;
}
