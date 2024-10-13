package org.example.view.statistics;

import org.example.dao.statistics.StatisticsDao;
import org.example.model.Statistics;

import java.sql.SQLException;
import java.util.List;

public class ListingStatisticsView {

    public static void main(String[] args) {
        try {
            StatisticsDao dao = new StatisticsDao();
            List<Statistics> statistics = dao.listar();
            for (Statistics statistic : statistics) {
                System.out.println(statistic.getMonth() + " - " + statistic.getEconomy() + ", " + statistic.getCost() + ", " + statistic.getYear());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
