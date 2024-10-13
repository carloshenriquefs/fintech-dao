package org.example.view.transactions;

import org.example.dao.transactions.TransactionsDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Transactions;

import java.sql.SQLException;

import static org.example.constants.Constants.CODE_NOT_EXIST;

public class SearchTransactionsByIdView {

    public static void main(String[] args) {
        try {
            TransactionsDao dao = new TransactionsDao();
            Transactions transactions = dao.pesquisar(3);
            System.out.println(transactions.getCode() + " - " + transactions.getValueTransaction() + ", " + transactions.getDescription());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(CODE_NOT_EXIST);
        }
    }
}
