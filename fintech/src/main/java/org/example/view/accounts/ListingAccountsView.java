package org.example.view.accounts;

import org.example.dao.accounts.AccountsDao;
import org.example.model.Accounts;

import java.sql.SQLException;
import java.util.List;

public class ListingAccountsView {

    public static void main(String[] args) {
        try {
            AccountsDao dao = new AccountsDao();
            List<Accounts> accounts = dao.listar();
            for (Accounts account : accounts) {
                System.out.println(account.getCodeUser() + " - " + account.getAccountNumber() + ", " + account.getBalance());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
