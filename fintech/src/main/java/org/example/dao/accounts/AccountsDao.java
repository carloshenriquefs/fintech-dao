package org.example.dao.accounts;

import org.example.exception.EntityNotFoundException;
import org.example.model.Accounts;

import java.sql.SQLException;
import java.util.List;

public interface AccountsDao {

    void register(Accounts accounts) throws SQLException;
    Accounts lookUp(long codigo)  throws SQLException, EntityNotFoundException;
    List<Accounts> list() throws SQLException, EntityNotFoundException;
    void update(Accounts accounts) throws SQLException;
    void remove(long codigo) throws SQLException, EntityNotFoundException;
    void closeConnection() throws SQLException;

}
