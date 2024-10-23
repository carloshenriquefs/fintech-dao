package org.example.view.statistics.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.model.Statistic;

import static org.example.constants.Constants.STATISTICS_REGISTERED;
import static org.example.factory.statistics.StatisticsFactory.createStatistics;
import static org.example.factory.statistics.StatisticsFactory.getStatisticsDao;

public class RegistrationStatisticsTest {

    public static void main(String[] args) {
        try {

            Statistic statistic = createStatistics();

            getStatisticsDao().insert(statistic, 2L);
            getStatisticsDao().closeConnection();

            System.out.println(STATISTICS_REGISTERED);

        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_INSERTING_DATA);
        }
    }
}
