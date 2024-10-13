package org.example.view.transactions;

import org.example.dao.transactions.TransactionsDao;
import org.example.model.Transactions;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.example.constants.Constants.TRANSACTIONS_REGISTERED;

public class RegistrationTransactionsView {

    public static void main(String[] args) {
        try {
            TransactionsDao dao = new TransactionsDao();
            Transactions transactions = new Transactions(3L, "DEBITO", "Pagamento a vista", 3850.0, LocalDate.of(2020,3,21));
            dao.cadastrar(transactions);
            dao.fecharConexao();
            System.out.println(TRANSACTIONS_REGISTERED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
