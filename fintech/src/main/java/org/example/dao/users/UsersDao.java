package org.example.dao.users;

import br.com.fiap.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UsersDao {

    void insert(User user);
    User getById(Long id);
    List<User> getAll();
//    void update(User user);
//    void remove(Long id);
    void closeConnection() throws SQLException;

}
