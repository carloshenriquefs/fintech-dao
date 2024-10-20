package org.example.view.transactions;

import org.example.dao.transactions.impl.TransactionsDaoImpl;
import org.example.model.Transaction;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static org.example.constants.Constants.INSERT_TRANSACTION;
import static org.example.constants.Constants.TRANSACTION_FOUND;
import static org.example.constants.Constants.TRANSACTION_LIST;
import static org.example.exception.ErrorTypeEnum.ERROR_CONNECTING_TO_DATABASE;
import static org.example.menu.Menu.exit;
import static org.example.menu.Menu.invalidOption;
import static org.example.menu.Menu.showMenu;

public class TransactionView {

    private static Scanner scanner = new Scanner(System.in);
    private static TransactionsDaoImpl dao;

    public static void main(String[] args) {
        try {

            dao = new TransactionsDaoImpl();

            int opcao;

            do {

                showMenu();

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
                        exit();
                        break;
                    default:
                        invalidOption();
                }

            } while (opcao != 0);

            dao.closeConnection();

        } catch (SQLException e) {
            System.err.println(ERROR_CONNECTING_TO_DATABASE + e.getMessage());
        }
    }

    private static void insert() {
        System.out.println("\n" + INSERT_TRANSACTION);

        System.out.print("\nInsira o ID do usuário associado à nota: ");
        Long id = scanner.nextLong();

        System.out.print("Digite o número: ");
        Long numeroConta = scanner.nextLong();

        System.out.print("Digite o tipo: ");
        String tipo = scanner.next() + scanner.nextLine();

        System.out.print("Digite a descrição: ");
        String descricao = scanner.next() + scanner.nextLine();

        System.out.print("Digite o valor: ");
        Double valor = scanner.nextDouble();

        System.out.print("Digite a data de transação: ");
        String dataTransacao = scanner.next() + scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataTransacao, formatter);

        Transaction notes = new Transaction(numeroConta, tipo, descricao, valor, data);

        dao.insert(notes, id);
    }

    private static void getById() {
        System.out.print("\nDigite o código da transação: ");
        Long codigo = scanner.nextLong();

        Transaction transaction = dao.getById(codigo);

        if (transaction == null) {
            System.out.println("\nTRANSACTION: " + codigo + " NÃO ENCONTRADO!");
        } else {
            System.out.println("\nTRANSACTION: " + codigo + " ENCONTRADO!");
        }

        System.out.println("\n" + TRANSACTION_FOUND);

        formatTransaction();
        System.out.printf("|%5s | %-20s | %-20s | %-20s   |%n",
                transaction.getCode(),
                transaction.getUserId(),
                transaction.getValueTransaction(),
                transaction.getDescription()
        );
        System.out.println("-------------------------------------------------------------------------------");

    }

    private static void getAll() {
        List<Transaction> transactions = dao.getAll();

        System.out.println("\n" + TRANSACTION_LIST);

        for (Transaction transaction : transactions) {
            formatTransaction();
            System.out.printf("|%5s | %-20s | %-20s | %-20s   |%n",
                    transaction.getCode(),
                    transaction.getUserId(),
                    transaction.getValueTransaction(),
                    transaction.getDescription()
            );
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    public static void formatTransaction() {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                              [SEARCH RESULT]                                |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%5s | %-20s | %-20s | %-20s   |%n", "ID", "USER ID", "VALUE TRANSACTION", "DESCRIPTION");
        System.out.println("-------------------------------------------------------------------------------");
    }
}
