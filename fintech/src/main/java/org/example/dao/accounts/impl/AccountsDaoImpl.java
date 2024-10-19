package org.example.dao.accounts.impl;

import org.example.dao.accounts.AccountsDao;
import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.factory.ConnectionFactory;
import org.example.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.ACCOUNT_NOT_FOUND;
import static org.example.constants.Constants.ERROR_LISTING_ACCOUNT;
import static org.example.constants.Constants.ERROR_LOOKING_UP_ACCOUNT_ID;
import static org.example.constants.Constants.ERROR_REGISTERING_ACCOUNT;

public class AccountsDaoImpl implements AccountsDao {

    private Connection connection;

    public AccountsDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void insert(Account accounts, Long id) {
        try {
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO tb_fth_accounts (" +
                            "cd_account, " +
                            "cd_user, " +
                            "ds_account, " +
                            "vl_balance) " +
                            "VALUES " +
                            "(seq_account.nextval, ?, ?, ?)");

            stm.setLong(1, id);
            stm.setString(2, accounts.getAccountNumber());
            stm.setDouble(3, accounts.getBalance());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.err.println(ERROR_REGISTERING_ACCOUNT + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_INSERTING_DATA);
        }
    }

    @Override
    public Account getById(Long id) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_accounts WHERE cd_account = ?");
            stm.setLong(1, id);
            ResultSet result = stm.executeQuery();

            if (!result.next())
                throw new AppFintechException(ACCOUNT_NOT_FOUND + id, null, ErrorTypeEnum.ERROR_SEARCHING_DATA);

            return parseAccount(result);

        } catch (SQLException e) {
            System.err.println(ERROR_LOOKING_UP_ACCOUNT_ID + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public List<Account> getAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_accounts");
            ResultSet result = stm.executeQuery();

            List<Account> lista = new ArrayList<>();

            while (result.next()) {
                lista.add(parseAccount(result));
            }

            return lista;

        } catch (SQLException e) {
            System.err.println(ERROR_LISTING_ACCOUNT + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Account parseAccount(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_account");
        String account = result.getString("ds_account");
        Double balance = result.getDouble("vl_balance");
        Long idUser = result.getLong("cd_user");

        return new Account(account, balance, idUser);
    }
}
