package org.example.view.users;

import org.example.dao.users.UsersDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.User;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.example.constants.Constants.USER_NOT_FOUND;
import static org.example.constants.Constants.USER_UPDATED;

public class UpdateUserView {

    public static void main(String[] args) {
        try {
            UsersDao dao = new UsersDao();
            User user = dao.pesquisar(3);
            user.setUsername("Ronaldo");
            user.setLastName("Meireles");
            user.setEmail("ronaldo.meireles@gmail.com");
            user.setPassword("12345");
            user.setAddress("Rua Branco Meira");
            user.setTelephone("11968745620");
            user.setGender("Masculino");
            user.setPosition("Bombeiro");
            user.setDate(LocalDate.of(2020, 2, 6));
            dao.atualizar(user);
            dao.fecharConexao();
            System.out.println(USER_UPDATED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(USER_NOT_FOUND);
        }
    }
}
