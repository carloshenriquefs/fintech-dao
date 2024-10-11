package org.example.view.users;

import org.example.dao.users.UsersDao;
import org.example.model.User;

import java.sql.SQLException;
import java.util.List;

public class ListingUserView {

    public static void main(String[] args) {
        try {
            UsersDao dao = new UsersDao();
            List<User> users = dao.listar();
            for (User user : users) {
                System.out.println(user.getCode() + " - " + user.getUsername() + ", " + user.getLastName() + ", " + user.getEmail());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
