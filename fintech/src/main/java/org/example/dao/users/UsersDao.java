package org.example.dao.users;

import org.example.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UsersDao {

    void insert(User user);
    User getById(Long id);
    List<User> getAll();
    void closeConnection() throws SQLException;

}
