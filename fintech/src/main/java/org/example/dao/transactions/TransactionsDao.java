package org.example.dao.transactions;

import org.example.exception.EntidadeNaoEncontradaException;
import org.example.factory.ConnectionFactory;
import org.example.model.Transactions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


import java.util.List;

import static org.example.constants.Constants.STATISTICS_NOT_FOUND;

public class TransactionsDao {

    private Connection connection;

    public TransactionsDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(Transactions transactions) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO tb_fth_transactions (cd_statistics, cd_user, ds_transaction_type, ds_description, vl_transaction, dt_transaction) VALUES (seq_user.nextval, ?, ?, ?, ?, ?)");
        stm.setLong(1, transactions.getCodeUser());
        stm.setString(2, transactions.getTransactionType());
        stm.setString(3, transactions.getDescription());
        stm.setDouble(4, transactions.getValueTransaction());
        stm.setDate(5, Date.valueOf(transactions.getDataTransacao()));
        stm.executeUpdate();
    }

    public void fecharConexao() throws SQLException {
        connection.close();
    }

    public Transactions pesquisar(long codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_transactions WHERE cd_user = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntidadeNaoEncontradaException(STATISTICS_NOT_FOUND);

        return parseUsuario(result);
    }

    public List<Transactions> listar() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_transactions");
        ResultSet result = stm.executeQuery();
        List<Transactions> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(parseUsuario(result));
        }

        return lista;
    }

    public void atualizar(Transactions transactions) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "UPDATE tb_fth_transactions SET cd_user = ?, ds_transaction_type = ?, " +
                        "ds_description = ?, vl_transaction = ?, dt_transaction = ?, " +
                        "WHERE cd_user = ?"
        );

        stm.setLong(1, transactions.getCodeUser());
        stm.setString(2, transactions.getTransactionType());
        stm.setString(3, transactions.getDescription());
        stm.setDouble(4, transactions.getValueTransaction());
        stm.setDate(5, Date.valueOf(transactions.getDataTransacao()));

        stm.executeUpdate();
    }

    public void remover(long codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM tb_fth_transactions WHERE cd_user = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntidadeNaoEncontradaException(STATISTICS_NOT_FOUND);
        }
    }

    private Transactions parseUsuario(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_user");
        String transactionType = result.getString("ds_transaction_type");
        String description = result.getString("ds_description");
        Double transactionValue = result.getDouble("vl_transaction");
        LocalDate transactionDate = result.getDate("dt_transaction").toLocalDate();

        return new Transactions(id, transactionType, description, transactionValue, transactionDate);
    }
}
