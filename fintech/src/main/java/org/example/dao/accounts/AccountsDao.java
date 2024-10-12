package org.example.dao.accounts;

import org.example.exception.EntidadeNaoEncontradaException;
import org.example.factory.ConnectionFactory;
import org.example.model.Accounts;
import org.example.model.Cards;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.STATISTICS_NOT_FOUND;

public class AccountsDao {

    private Connection connection;

    public AccountsDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(Accounts accounts) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO tb_fth_accounts (cd_account, cd_user, ds_account, vl_balance) VALUES (seq_user.nextval, ?, ?, ?)");
        stm.setLong(1, accounts.getCodeUser());
        stm.setString(2, accounts.getAccountNumber());
        stm.setDouble(3, accounts.getBalance());
        stm.executeUpdate();
    }

    public void fecharConexao() throws SQLException {
        connection.close();
    }

    public Accounts pesquisar(long codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_accounts WHERE cd_user = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntidadeNaoEncontradaException(STATISTICS_NOT_FOUND);

        return parseUsuario(result);
    }

    public List<Accounts> listar() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_accounts");
        ResultSet result = stm.executeQuery();
        List<Accounts> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(parseUsuario(result));
        }

        return lista;
    }

    public void atualizar(Accounts accounts) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "UPDATE tb_fth_accounts SET cd_user = ?, ds_account = ?, " +
                        "vl_balance = ? WHERE cd_user = ?"
        );

        stm.setLong(1, accounts.getCodeUser());
        stm.setString(2, accounts.getAccountNumber());
        stm.setDouble(3, accounts.getBalance());

        stm.executeUpdate();
    }

    public void remover(long codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM tb_fth_accounts WHERE cd_user = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntidadeNaoEncontradaException(STATISTICS_NOT_FOUND);
        }
    }

    private Accounts parseUsuario(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_user");
        String account = result.getString("ds_account");
        Double balance = result.getDouble("vl_balance");

        return new Accounts(id, account, balance);
    }
}
