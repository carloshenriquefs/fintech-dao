package org.example.view.accounts;

import org.example.dao.accounts.AccountsDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Accounts;

import java.sql.SQLException;

import static org.example.constants.Constants.ACCOUNTS_NOT_FOUND;
import static org.example.constants.Constants.ACCOUNTS_UPDATED;

public class UpdateAccountsView {

    public static void main(String[] args) {
        try {
            AccountsDao dao = new AccountsDao();
            Accounts accounts = dao.pesquisar(3L);
            accounts.setCodeUser(3L);
            accounts.setAccountNumber("1234");
            accounts.setBalance(10000.0);
            dao.atualizar(accounts);
            dao.fecharConexao();
            System.out.println(ACCOUNTS_UPDATED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(ACCOUNTS_NOT_FOUND);
        }
    }
}
