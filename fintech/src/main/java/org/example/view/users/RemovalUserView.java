package org.example.view.users;

import org.example.dao.users.UsersDao;
import org.example.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

import static org.example.constants.Constants.USER_NOT_FOUND;
import static org.example.constants.Constants.USER_REMOVED;

public class RemovalUserView {

    public static void main(String[] args) {
        try {
            UsersDao dao = new UsersDao();
            dao.remover(2);
            dao.fecharConexao();
            System.out.println(USER_REMOVED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(USER_NOT_FOUND);
        }
    }
}
