package org.example.view.statistics;

import org.example.dao.statistics.StatisticsDao;
import org.example.model.Statistics;

import java.sql.SQLException;

import static org.example.constants.Constants.STATISTICS_REGISTERED;

public class RegistrationStatisticsView {

    public static void main(String[] args) {
        try {
            StatisticsDao dao = new StatisticsDao();
            Statistics statistics = new Statistics(3L, 2, 2040, 3000.0, 500.0, 2800.0);
            dao.cadastrar(statistics);
            dao.fecharConexao();
            System.out.println(STATISTICS_REGISTERED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
