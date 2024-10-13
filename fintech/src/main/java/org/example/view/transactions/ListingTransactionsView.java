package org.example.view.transactions;

import org.example.dao.transactions.TransactionsDao;
import org.example.model.Transactions;

import java.sql.SQLException;
import java.util.List;

public class ListingTransactionsView {

    public static void main(String[] args) {
        try {
            TransactionsDao dao = new TransactionsDao();
            List<Transactions> transactions = dao.listar();
            for (Transactions transaction : transactions) {
                System.out.println(transaction.getCodeUser() + " - " + transaction.getValueTransaction() + ", " + transaction.getDescription());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
