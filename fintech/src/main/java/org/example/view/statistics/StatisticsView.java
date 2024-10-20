package org.example.view.statistics;

import org.example.dao.statistics.impl.StatisticsDaoImpl;
import org.example.model.Statistic;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static org.example.constants.Constants.ERROR_CONNECTING_TO_DATABASE;
import static org.example.constants.Constants.INSERT_STATISTIC;
import static org.example.constants.Constants.STATISTICS_FOUND;
import static org.example.constants.Constants.STATISTICS_LIST;
import static org.example.menu.Menu.exit;
import static org.example.menu.Menu.invalidOption;
import static org.example.menu.Menu.showMenu;

public class StatisticsView {

    private static Scanner scanner = new Scanner(System.in);
    private static StatisticsDaoImpl dao;

    public static void main(String[] args) {
        try {

            dao = new StatisticsDaoImpl();

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
        System.out.println("\n" + INSERT_STATISTIC);

        System.out.print("\nInsira o ID do usuário associado à nota: ");
        Long id = scanner.nextLong();

        System.out.print("Digite o mês: ");
        Integer month = scanner.nextInt();

        System.out.print("Digite o ano: ");
        Integer ano = scanner.nextInt();

        System.out.print("Digite o saldo: ");
        Double orcamento = scanner.nextDouble();

        System.out.print("Digite o custo: ");
        Double custo = scanner.nextDouble();

        System.out.print("Digite o valor da economia: ");
        Double economia = scanner.nextDouble();

        Statistic notes = new Statistic(id, month, ano, orcamento, custo, economia);

        dao.insert(notes, id);
    }

    private static void getById() {
        System.out.print("\nDigite o código da estatística: ");
        Long codigo = scanner.nextLong();

        Statistic statistic = dao.getById(codigo);

        if (statistic == null) {
            System.out.println("\nSTATISTICS: " + codigo + " NÃO ENCONTRADO!");
        } else {
            System.out.println("\nSTATISTICS: " + codigo + " ENCONTRADO!");
        }

        System.out.println("\n" + STATISTICS_FOUND);

        formatStatistics();
        System.out.printf("|%5s | %-20s | %-20s | %-20s   |%n",
                statistic.getCode(),
                statistic.getBudge(),
                statistic.getCost(),
                statistic.getEconomy()
        );
        System.out.println("-------------------------------------------------------------------------------");
    }

    private static void getAll() {
        List<Statistic> statistics = dao.getAll();

        System.out.println("\n" + STATISTICS_LIST);

        for (Statistic statistic : statistics) {
            formatStatistics();
            System.out.printf("|%5s   | %-20s | %-20s | %-20s |%n",
                    statistic.getCode(),
                    statistic.getBudge(),
                    statistic.getCost(),
                    statistic.getEconomy()
            );
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    public static void formatStatistics() {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                              [SEARCH RESULT]                                |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%5s | %-20s | %-20s | %-20s |%n", "USER ID", "BUDGE", "COST", "ECONOMY");
        System.out.println("-------------------------------------------------------------------------------");
    }
}
