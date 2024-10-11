package org.example.view.users;

import org.example.dao.users.UsersDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.User;

import java.sql.SQLException;

import static org.example.constants.Constants.CODE_NOT_EXIST;

public class SearchUserByIdView {

    public static void main(String[] args) {
        try {
            UsersDao dao = new UsersDao();
            User user = dao.pesquisar(41);
            System.out.println(user.getCode() + " - " + user.getUsername() + ", " + user.getLastName() + ", " + user.getEmail());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(CODE_NOT_EXIST);
        }
    }
}
