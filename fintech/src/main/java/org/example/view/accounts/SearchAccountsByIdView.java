package org.example.view.accounts;

import org.example.dao.accounts.AccountsDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Accounts;

import java.sql.SQLException;

import static org.example.constants.Constants.CODE_NOT_EXIST;

public class SearchAccountsByIdView {

    public static void main(String[] args) {
        try {
            AccountsDao dao = new AccountsDao();
            Accounts account = dao.pesquisar(3);
            System.out.println(account.getCodeUser() + " - " + account.getAccountNumber() + ", " + account.getBalance());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(CODE_NOT_EXIST);
        }
    }
}
