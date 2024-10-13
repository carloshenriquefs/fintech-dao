package org.example.view.transactions;

import org.example.dao.transactions.TransactionsDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Transactions;

import java.sql.SQLException;

import static org.example.constants.Constants.TRANSACTIONS_NOT_FOUND;
import static org.example.constants.Constants.TRANSACTIONS_UPDATED;

public class UpdateTransactionsView {

    public static void main(String[] args) {
        try {
            TransactionsDao dao = new TransactionsDao();
            Transactions transactions = dao.pesquisar(3);
            transactions.setTransactionType("Credito");
            dao.atualizar(transactions);
            dao.fecharConexao();
            System.out.println(TRANSACTIONS_UPDATED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(TRANSACTIONS_NOT_FOUND);
        }
    }
}
