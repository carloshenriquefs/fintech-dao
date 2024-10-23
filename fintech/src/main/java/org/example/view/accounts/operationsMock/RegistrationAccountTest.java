package org.example.view.accounts.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.factory.account.AccountFactory;
import org.example.model.Account;

import static org.example.constants.Constants.ACCOUNTS_REGISTERED;
import static org.example.factory.account.AccountFactory.getAccountDao;

public class RegistrationAccountTest {
    public static void main(String[] args) {
        try {
            Account accounts = AccountFactory.createAccounts();

            getAccountDao().insert(accounts, 2L);
            getAccountDao().closeConnection();

            System.out.println(ACCOUNTS_REGISTERED);

        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_INSERTING_DATA);
        }
    }
}
