package org.example.view.accounts;

import org.example.dao.accounts.AccountsDao;
import org.example.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

import static org.example.constants.Constants.ACCOUNTS_NOT_FOUND;
import static org.example.constants.Constants.ACCOUNTS_REMOVED;

public class RemovalAccountsView {

    public static void main(String[] args) {
        try {
            AccountsDao dao = new AccountsDao();
            dao.remover(3);
            dao.fecharConexao();
            System.out.println(ACCOUNTS_REMOVED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(ACCOUNTS_NOT_FOUND);
        }
    }
}
