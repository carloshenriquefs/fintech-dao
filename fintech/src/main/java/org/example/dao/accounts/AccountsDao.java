package org.example.dao.accounts;

import org.example.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountsDao {

    void insert(Account accounts, Long id);
    Account getById(Long id);
    List<Account> getAll();
    void closeConnection() throws SQLException;

}
