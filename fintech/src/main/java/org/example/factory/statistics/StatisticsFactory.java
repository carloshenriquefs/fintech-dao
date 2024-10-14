package org.example.factory.statistics;

import org.example.dao.statistics.StatisticsDao;
import org.example.dao.statistics.impl.StatisticsDaoImpl;
import org.example.model.Statistics;
import org.example.model.builder.StatisticsBuilder;

import java.sql.SQLException;

public class StatisticsFactory {

    public static StatisticsDao getStatisticsDao() throws SQLException {
        return new StatisticsDaoImpl();
    }

    public static Statistics createStatistics() {
        return new StatisticsBuilder()
                .setCode(1L)
                .setUserCode(1L)
                .setMonth(5)
                .setYear(2015)
                .setBudge(3560.0)
                .setCost(5000.0)
                .setEconomy(10000.0)
                .build();
    }
}
