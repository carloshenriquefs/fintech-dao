package org.example.view.accounts;

import org.example.dao.accounts.impl.AccountsDaoImpl;
import org.example.dao.users.impl.UsersDaoImpl;
import org.example.menu.Menu;
import org.example.model.Account;
import org.example.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static org.example.constants.Constants.ACCOUNT_FOUND;
import static org.example.constants.Constants.ACCOUNT_LIST;
import static org.example.constants.Constants.ERROR_CONNECTING_TO_DATABASE;
import static org.example.constants.Constants.INSERT_ACCOUNT;

public class AccountView {

    private static Scanner scanner = new Scanner(System.in);
    private static AccountsDaoImpl dao;
    private static UsersDaoImpl usersDao;

    public static void main(String[] args) {
        try {

            dao = new AccountsDaoImpl();
            usersDao = new UsersDaoImpl();

            int opcao;

            do {

                Menu.showMenu();

                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        insert();
                        break;
                    case 2:
                        getById();
                        break;
                    case 3:
                        getAll();
                        break;
                    case 0:
                        Menu.exit();
                        break;
                    default:
                        Menu.invalidOption();
                }

            } while (opcao != 0);

            dao.closeConnection();

        } catch (SQLException e) {
            System.err.println(ERROR_CONNECTING_TO_DATABASE + e.getMessage());
        }
    }

    public static void insert() {
        System.out.println("\n" + INSERT_ACCOUNT);

        System.out.print("\nInsira o ID do usuário associado à conta: ");
        Long userId = scanner.nextLong();

        User user = usersDao.getById(userId);

        if (user == null) {
            System.out.println("Usuário com ID " + userId + " não encontrado.");
        } else {
            System.out.println("Usuário com ID " + userId + " encontrado.");
        }

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.next();

        System.out.print("Digite o saldo da conta: ");
        Double saldo = scanner.nextDouble();

        Account accounts = new Account(numeroConta, saldo, userId);

        dao.insert(accounts, userId);
    }

    public static void getById() {
        System.out.print("Digite o código da conta: ");
        Long codigo = scanner.nextLong();

        Account account = dao.getById(codigo);

        System.out.println("\n" + ACCOUNT_FOUND);

        formatAccount();
        System.out.printf("|%5s | %-20s | %-20s |%n",
                account.getUserId(),
                account.getAccountNumber(),
                account.getBalance()
        );
        System.out.println("------------------------------------------------------");
    }

    public static void getAll() {
        List<Account> accounts = dao.getAll();

        System.out.println("\n" + ACCOUNT_LIST);

        for (Account account : accounts) {
            formatAccount();
            System.out.printf("|%5s | %-20s | %-20s | %-20s   |%n",
                    account.getId(),
                    account.getAccountNumber(),
                    account.getBalance(),
                    account.getUserId()
            );
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    public static void formatAccount() {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                              [SEARCH RESULT]                                |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%5s | %-20s | %-20s | %-20s   |%n", "ID", "ACCOUNT NUMBER", "BALANCE", "CODE USER");
        System.out.println("-------------------------------------------------------------------------------");
    }
}
