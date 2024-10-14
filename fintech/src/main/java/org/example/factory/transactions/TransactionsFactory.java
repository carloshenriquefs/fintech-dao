package org.example.factory.transactions;

import org.example.dao.transactions.TransactionsDao;
import org.example.dao.transactions.impl.TransactionsDaoImpl;
import org.example.model.Transactions;
import org.example.model.builder.TransactionsBuilder;

import java.sql.SQLException;
import java.time.LocalDate;

public class TransactionsFactory {

    public static TransactionsDao getTransactionsDao() throws SQLException {
        return new TransactionsDaoImpl();
    }

    public static Transactions createTransaction() {
        return new TransactionsBuilder()
                .setCode(1L)
                .setCodeUser(2L)
                .setTransactionType("Debito")
                .setDescription("Transacao Realizada")
                .setValueTransaction(2400.0)
                .setDataTransacao(LocalDate.of(2020, 4, 12))
                .build();
    }
}
