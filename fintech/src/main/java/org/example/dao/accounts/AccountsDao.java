package org.example.dao.accounts;

import br.com.fiap.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountsDao {

    void insert(Account accounts, Long id);
    Account getById(Long id);
    List<Account> getAll();
//    void update(Account accounts, Long id);
//    void remove(Long id);
    void closeConnection() throws SQLException;

}
