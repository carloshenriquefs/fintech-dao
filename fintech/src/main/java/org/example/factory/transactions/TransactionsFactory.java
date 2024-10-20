package org.example.factory.transactions;

import org.example.dao.transactions.TransactionsDao;
import org.example.dao.transactions.impl.TransactionsDaoImpl;
import org.example.model.Transaction;
import org.example.model.builder.TransactionBuilder;

import java.sql.SQLException;
import java.time.LocalDate;

public class TransactionsFactory {

    public static TransactionsDao getTransactionsDao() throws SQLException {
        return new TransactionsDaoImpl();
    }

    public static Transaction createTransaction() {
        return new TransactionBuilder()
                .setUserId(2L)
                .setTransactionType("expenses")
                .setDescription("Transacao Realizada")
                .setValueTransaction(2400.0)
                .setDataTransacao(LocalDate.of(2020, 4, 12))
                .build();
    }
}
