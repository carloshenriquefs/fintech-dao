package org.example.view.statistics.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.model.Statistic;

import static org.example.factory.statistics.StatisticsFactory.getStatisticsDao;

public class ListingStatisticsTest {

    public static void main(String[] args) {
        try {

            Statistic statistics = getStatisticsDao().getById(3L);

            System.out.println(statistics.getMonth() + " - " + statistics.getCode() + ", " + statistics.getEconomy() + ", " + statistics.getBudge());

            getStatisticsDao().closeConnection();

        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }
}
