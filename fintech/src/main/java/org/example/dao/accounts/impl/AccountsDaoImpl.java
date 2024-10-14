package org.example.dao.accounts.impl;

import org.example.dao.accounts.AccountsDao;
import org.example.exception.EntityNotFoundException;
import org.example.factory.ConnectionFactory;
import org.example.model.Accounts;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.ACCOUNTS_NOT_FOUND;

public class AccountsDaoImpl implements AccountsDao {

    private PreparedStatement stmt = null;
    private Connection connection = null;

    public AccountsDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void register(Accounts accounts) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "INSERT INTO tb_fth_accounts (" +
                        "cd_account, " +
                        "cd_user, " +
                        "ds_account, " +
                        "vl_balance) " +
                        "VALUES " +
                        "(seq_user.nextval, ?, ?, ?)");

        stm.setLong(1, accounts.getUser().getCode());
        stm.setString(2, accounts.getAccountNumber());
        stm.setDouble(3, accounts.getBalance());

        stm.executeUpdate();
    }

    public Accounts lookUp(long codigo) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_accounts WHERE cd_user = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntityNotFoundException(ACCOUNTS_NOT_FOUND);

        return parseAccount(result);
    }

    public List<Accounts> list() throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_accounts");
        ResultSet result = stm.executeQuery();
        List<Accounts> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(parseAccount(result));
        }

        return lista;
    }

    public void update(Accounts accounts) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "UPDATE tb_fth_accounts " +
                        "SET " +
                        "cd_user = ?, " +
                        "ds_account = ?, " +
                        "vl_balance = ? " +
                        "WHERE " +
                        "cd_user = ?"
        );

        stm.setLong(1, accounts.getUser().getCode());
        stm.setString(2, accounts.getAccountNumber());
        stm.setDouble(3, accounts.getBalance());

        stm.executeUpdate();
    }

    public void remove(long codigo) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM tb_fth_accounts WHERE cd_user = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException(ACCOUNTS_NOT_FOUND);
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Accounts parseAccount(ResultSet result) throws SQLException, EntityNotFoundException {
        Long id = result.getLong("cd_account");
        String account = result.getString("ds_account");
        Double balance = result.getDouble("vl_balance");
        Long idUser = result.getLong("cd_user");

        User user = lookUp(idUser).getUser();

        return new Accounts(id, account, balance, user);
    }

}
