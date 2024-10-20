package org.example.dao.transactions.impl;

import org.example.dao.transactions.TransactionsDao;
import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.factory.ConnectionFactory;
import org.example.model.Transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.ERROR_LISTING_TRANSACTIONS;
import static org.example.constants.Constants.ERROR_LOOKING_UP_TRANSACTION_ID;
import static org.example.constants.Constants.ERROR_REGISTERING_TRANSACTION;
import static org.example.constants.Constants.TRANSACTIONS_NOT_FOUND;

public class TransactionsDaoImpl implements TransactionsDao {

    private Connection connection;

    public TransactionsDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void insert(Transaction transaction, Long id) {
        try {

            String transactionType = transaction.getTransactionType();

            if (!transactionType.equals("expenses") && !transactionType.equals("income")) {
                throw new IllegalArgumentException("Tipo de transação invalida: " + transactionType);
            }

            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO tb_fth_transactions (" +
                            "cd_transactions, " +
                            "cd_user, " +
                            "ds_transaction_type, " +
                            "ds_description, " +
                            "vl_transaction, " +
                            "dt_transaction) " +
                            "VALUES (seq_transaction.nextval, ?, ?, ?, ?, ?)");

            stm.setLong(1, id);
            stm.setString(2, transaction.getTransactionType());
            stm.setString(3, transaction.getDescription());
            stm.setDouble(4, transaction.getValueTransaction());
            stm.setDate(5, Date.valueOf(transaction.getDataTransacao()));

            stm.executeUpdate();

        } catch (SQLException e) {
            System.err.println(ERROR_REGISTERING_TRANSACTION + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_INSERTING_DATA);
        }
    }

    @Override
    public Transaction getById(Long id) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_transactions WHERE cd_transactions = ?");
            stm.setLong(1, id);
            ResultSet result = stm.executeQuery();

            if (!result.next())
                throw new AppFintechException(TRANSACTIONS_NOT_FOUND + id, null, ErrorTypeEnum.ERROR_SEARCHING_DATA);

            return parseTransactions(result);

        } catch (SQLException e) {
            System.err.println(ERROR_LOOKING_UP_TRANSACTION_ID + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public List<Transaction> getAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_transactions");
            ResultSet result = stm.executeQuery();

            List<Transaction> lista = new ArrayList<>();

            while (result.next()) {
                lista.add(parseTransactions(result));
            }

            return lista;

        } catch (SQLException e) {
            System.err.println(ERROR_LISTING_TRANSACTIONS + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Transaction parseTransactions(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_transactions");
        String transactionType = result.getString("ds_transaction_type");
        String description = result.getString("ds_description");
        Double transactionValue = result.getDouble("vl_transaction");
        LocalDate transactionDate = result.getDate("dt_transaction").toLocalDate();

        return new Transaction(id, transactionType, description, transactionValue, transactionDate);
    }
}
