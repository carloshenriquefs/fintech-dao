package org.example.dao.transactions.impl;

import org.example.dao.transactions.TransactionsDao;
import org.example.exception.EntityNotFoundException;
import org.example.factory.ConnectionFactory;
import org.example.model.Transactions;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.TRANSACTIONS_NOT_FOUND;

public class TransactionsDaoImpl implements TransactionsDao {

    private Connection connection;

    public TransactionsDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void register(Transactions transactions) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "INSERT INTO tb_fth_transactions (" +
                        "cd_statistics, " +
                        "cd_user, " +
                        "ds_transaction_type, " +
                        "ds_description, " +
                        "vl_transaction, " +
                        "dt_transaction) " +
                        "VALUES (seq_user.nextval, ?, ?, ?, ?, ?)");

        stm.setLong(1, transactions.getCodeUser());
        stm.setString(2, transactions.getTransactionType());
        stm.setString(3, transactions.getDescription());
        stm.setDouble(4, transactions.getValueTransaction());
        stm.setDate(5, Date.valueOf(transactions.getDataTransacao()));

        stm.executeUpdate();
    }

    public Transactions lookUp(long codigo) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_transactions WHERE cd_user = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntityNotFoundException(TRANSACTIONS_NOT_FOUND);

        return parseUser(result);
    }

    public List<Transactions> list() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_transactions");
        ResultSet result = stm.executeQuery();
        List<Transactions> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(parseUser(result));
        }

        return lista;
    }

    public void update(Transactions transactions) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "UPDATE tb_fth_transactions " +
                        "SET cd_user = ?, " +
                        "ds_transaction_type = ?, " +
                        "ds_description = ?, " +
                        "vl_transaction = ?, " +
                        "dt_transaction = ?, " +
                        "WHERE cd_user = ?"
        );

        stm.setLong(1, transactions.getCodeUser());
        stm.setString(2, transactions.getTransactionType());
        stm.setString(3, transactions.getDescription());
        stm.setDouble(4, transactions.getValueTransaction());
        stm.setDate(5, Date.valueOf(transactions.getDataTransacao()));

        stm.executeUpdate();
    }

    public void remove(long codigo) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM tb_fth_transactions WHERE cd_user = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException(TRANSACTIONS_NOT_FOUND);
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Transactions parseUser(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_user");
        String transactionType = result.getString("ds_transaction_type");
        String description = result.getString("ds_description");
        Double transactionValue = result.getDouble("vl_transaction");
        LocalDate transactionDate = result.getDate("dt_transaction").toLocalDate();

        return new Transactions(id, transactionType, description, transactionValue, transactionDate);
    }
}
