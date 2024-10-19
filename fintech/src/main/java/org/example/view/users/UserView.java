package org.example.view.users;

import org.example.dao.users.impl.UsersDaoImpl;
import org.example.model.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static org.example.constants.Constants.*;
import static org.example.exception.ErrorTypeEnum.ERROR_CONNECTING_TO_DATABASE;
import static org.example.menu.Menu.*;

public class UserView {

    private static Scanner scanner = new Scanner(System.in);

    private static UsersDaoImpl usersDao;

    public static void main(String[] args) {
        try {

            usersDao = new UsersDaoImpl();

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

            usersDao.closeConnection();

        } catch (SQLException e) {
            System.err.println(ERROR_CONNECTING_TO_DATABASE + e.getMessage());
        }
    }

    private static void insert() {
        System.out.println("\n" + INSERT_USER);

        System.out.print("\nDigite o nome do usuário: ");
        String nome = scanner.next() + scanner.nextLine();

        System.out.print("Digite o sobrenome do usuário: ");
        String sobrenome = scanner.next() + scanner.nextLine();

        System.out.print("Digite o e-mail do usuário: ");
        String email = scanner.next() + scanner.nextLine();

        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.next() + scanner.nextLine();

        System.out.print("Digite o endereço do usuário: ");
        String endereco = scanner.next() + scanner.nextLine();

        System.out.print("Digite o telefone do usuário: ");
        String telefone = scanner.next() + scanner.nextLine();

        System.out.print("Digite o genero do usuário: ");
        String genero = scanner.next() + scanner.nextLine();

        System.out.print("Digite o cargo do usuário: ");
        String cargo = scanner.next() + scanner.nextLine();

        System.out.print("Digite a data de registro do usuário: ");
        String dateRegistration = scanner.next() + scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dateRegistration, formatter);

        User user = new User(nome, sobrenome, email, senha, endereco, telefone, genero, cargo, data);

        usersDao.insert(user);
    }

    private static void getById() {
        System.out.print("\nDigite o código do usuário: ");
        Long codigo = scanner.nextLong();

        User user = usersDao.getById(codigo);

        if (user == null) {
            System.out.println("\nUSER: " + codigo + " NÃO ENCONTRADO!");
        } else {
            System.out.println("\nUSER: " + codigo + " ENCONTRADO!");
        }

        System.out.println("\n" + USER_FOUND);

        formatUser();
        System.out.printf("|%5s | %-20s | %-20s | %-20s |%n",
                user.getUsername(),
                user.getLastName(),
                user.getEmail(),
                user.getPosition()
        );
        System.out.println("-------------------------------------------------------------------------------");
    }

    private static void getAll() {
        List<User> users = usersDao.getAll();

        System.out.println("\n" + USER_LIST);

        for (User user : users) {
            formatUser();

            System.out.printf("|%5s | %-20s | %-20s | %-20s|%n",
                    user.getUsername(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPosition()
            );
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    public static void formatUser() {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                              [SEARCH RESULT]                                |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%5s    | %-20s | %-20s | %-20s|%n", "NAME", "USERNAME", "EMAIL", "POSITION");
        System.out.println("-------------------------------------------------------------------------------");
    }
}
