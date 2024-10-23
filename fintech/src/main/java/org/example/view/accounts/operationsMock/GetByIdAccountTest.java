package org.example.view.accounts.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.model.Transaction;

import static org.example.factory.transactions.TransactionsFactory.getTransactionsDao;

public class GetByIdAccountTest {
    public static void main(String[] args) {
        try {

            Transaction transactions = getTransactionsDao().getById(3L);

            System.out.println(transactions.getCode() + " - " + transactions.getValueTransaction() + ", " + transactions.getDescription());

            getTransactionsDao().closeConnection();

        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }
}
