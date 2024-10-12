package org.example.view.accounts;

import org.example.dao.accounts.AccountsDao;
import org.example.model.Accounts;

import java.sql.SQLException;

import static org.example.constants.Constants.ACCOUNTS_REGISTERED;

public class RegistrationAccountsView {

    public static void main(String[] args) {
        try {
            AccountsDao dao = new AccountsDao();
            Accounts statistics = new Accounts(3L, "142", 3850.0);
            dao.cadastrar(statistics);
            dao.fecharConexao();
            System.out.println(ACCOUNTS_REGISTERED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
