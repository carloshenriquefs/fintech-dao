package org.example.view.statistics.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.model.Statistic;

import java.util.List;

import static org.example.factory.statistics.StatisticsFactory.getStatisticsDao;

public class GetByIdStatisticsTest {

    public static void main(String[] args) {
        try {
            List<Statistic> statistics = getStatisticsDao().getAll();

            for (Statistic statistic : statistics) {
                System.out.println(statistic.getMonth() + " - " + statistic.getEconomy() + ", " + statistic.getCost() + ", " + statistic.getYear());
            }

            getStatisticsDao().closeConnection();
        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }
}
