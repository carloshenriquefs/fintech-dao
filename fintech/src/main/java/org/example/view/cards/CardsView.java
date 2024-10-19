package org.example.view.cards;

import org.example.dao.cards.impl.CardsDaoImpl;
import org.example.model.Card;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static org.example.constants.Constants.*;
import static org.example.menu.Menu.*;

public class CardsView {

    private static Scanner scanner = new Scanner(System.in);
    private static CardsDaoImpl dao;

    public static void main(String[] args) {
        try {

            dao = new CardsDaoImpl();

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
        System.out.println("\n" + INSERT_CARD);

        System.out.print("\nInsira o ID do usuário associado à nota: ");
        Long id = scanner.nextLong();

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.next() + scanner.nextLine();

        System.out.print("Digite a bandeira da sua conta: ");
        String bandeira = scanner.next() + scanner.nextLine();

        System.out.print("Digite a validade da conta: ");
        String validade = scanner.next() + scanner.nextLine();

        System.out.print("Digite o saldo da sua conta: ");
        Double saldo = scanner.nextDouble();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(validade, formatter);

        Card cards = new Card(id, numeroConta, bandeira, data, saldo);

        dao.insert(cards, id);
    }

    private static void getById() {
        System.out.print("\nDigite o código do cartão: ");
        Long codigo = scanner.nextLong();

        Card card = dao.getById(codigo);

        if (card == null) {
            System.out.println("\nCARD: " + codigo + " NÃO ENCONTRADO!");
        } else {
            System.out.println("\nCARD: " + codigo + " ENCONTRADO!");
        }

        System.out.println("\n" + CARD_FOUND);

        formatCard();
        System.out.printf("|%5s | %-20s | %-20s | %-20s   |%n",
                card.getUserId(),
                card.getNumberCard(),
                card.getBalance(),
                card.getFlag()
        );
        System.out.println("-------------------------------------------------------------------------------");
    }

    private static void getAll() {
        List<Card> cards = dao.getAll();

        System.out.println("\n" + CARD_LIST);

        for (Card card : cards) {
            formatCard();
            System.out.printf("|%5s   | %-20s | %-20s | %-20s |%n",
                    card.getUserId(),
                    card.getNumberCard(),
                    card.getBalance(),
                    card.getFlag()
            );
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    public static void formatCard() {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                              [SEARCH RESULT]                                |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%5s | %-20s | %-20s | %-20s |%n", "USER ID", "NUMBER CARD", "BALANCE", "FLAG");
        System.out.println("-------------------------------------------------------------------------------");
    }
}
