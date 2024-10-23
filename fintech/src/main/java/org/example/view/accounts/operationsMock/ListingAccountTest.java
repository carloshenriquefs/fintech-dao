package org.example.view.accounts.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.model.Account;

import java.util.List;

import static org.example.factory.account.AccountFactory.getAccountDao;

public class ListingAccountTest {
    public static void main(String[] args) {
        try {

            List<Account> accounts = getAccountDao().getAll();

            for (Account account : accounts) {
                System.out.println(account.getUserId() + " - " + account.getAccountNumber() + ", " + account.getBalance());
            }

            getAccountDao().closeConnection();

        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }
}
