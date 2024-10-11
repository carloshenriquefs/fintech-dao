package org.example.view.users;

import org.example.dao.users.UsersDao;
import org.example.model.User;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.example.constants.Constants.USER_REGISTERED;

public class RegistrationUserView {

    public static void main(String[] args) {
        try {
            UsersDao dao = new UsersDao();

            User user = new User(
                    "Marcelo",
                    "Santos",
                    "marceloSantos@gmail.com",
                    "9876543210",
                    "Rua Amarildo Compas",
                    "1198785632",
                    "Masculino",
                    "Balconista",
                    LocalDate.of(2012, 3, 12)
            );

            dao.cadastrar(user);
            dao.fecharConexao();
            System.out.println(USER_REGISTERED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

