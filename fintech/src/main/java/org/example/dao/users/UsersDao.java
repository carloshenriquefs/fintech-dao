package org.example.dao.users;

import org.example.exception.EntityNotFoundException;
import org.example.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UsersDao {

    void register(User user) throws SQLException;
    User lookUp(long coidgo) throws SQLException, EntityNotFoundException;
    List<User> list() throws SQLException;
    void update(User user) throws SQLException;
    void remove(long codigo) throws SQLException, EntityNotFoundException;
    void closeConnection() throws SQLException;

}
