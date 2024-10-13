package org.example.view.transactions;

import org.example.dao.transactions.TransactionsDao;
import org.example.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

import static org.example.constants.Constants.TRANSACTIONS_NOT_FOUND;
import static org.example.constants.Constants.TRANSACTIONS_REMOVED;

public class RemovalTransactionsView {

    public static void main(String[] args) {
        try {
            TransactionsDao dao = new TransactionsDao();
            dao.remover(3);
            dao.fecharConexao();
            System.out.println(TRANSACTIONS_REMOVED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(TRANSACTIONS_NOT_FOUND);
        }
    }
}
