package org.example.dao.statistics.impl;

import org.example.dao.statistics.StatisticsDao;
import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.factory.ConnectionFactory;
import org.example.model.Statistic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.ERROR_LISTING_STATISTICS;
import static org.example.constants.Constants.ERROR_LOOKING_UP_STATISTIC_ID;
import static org.example.constants.Constants.ERROR_REGISTERING_STATISTIC;
import static org.example.constants.Constants.STATISTICS_NOT_FOUND;

public class StatisticsDaoImpl implements StatisticsDao {

    private Connection connection;

    public StatisticsDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void insert(Statistic statistic, Long id) {
        try {
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO tb_fth_statistics (" +
                            "cd_statistics, " +
                            "cd_user, " +
                            "dt_month, " +
                            "dt_year, " +
                            "vl_budge, " +
                            "vl_cost, " +
                            "vl_economy) " +
                            "VALUES (seq_statistic.nextval, ?, ?, ?, ?, ?, ?)");

            stm.setLong(1, id);
            stm.setInt(2, statistic.getMonth());
            stm.setInt(3, statistic.getYear());
            stm.setDouble(4, statistic.getBudge());
            stm.setDouble(5, statistic.getCost());
            stm.setDouble(6, statistic.getEconomy());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.err.println(ERROR_REGISTERING_STATISTIC + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_INSERTING_DATA);
        }
    }

    @Override
    public Statistic getById(Long id) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_statistics WHERE cd_statistics = ?");
            stm.setLong(1, id);
            ResultSet result = stm.executeQuery();

            if (!result.next())
                throw new AppFintechException(STATISTICS_NOT_FOUND + id, null, ErrorTypeEnum.ERROR_SEARCHING_DATA);

            return parseStatistics(result);

        } catch (SQLException e) {
            System.err.println(ERROR_LOOKING_UP_STATISTIC_ID + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public List<Statistic> getAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_statistics");
            ResultSet result = stm.executeQuery();

            List<Statistic> lista = new ArrayList<>();

            while (result.next()) {
                lista.add(parseStatistics(result));
            }

            return lista;

        } catch (SQLException e) {
            System.err.println(ERROR_LISTING_STATISTICS + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Statistic parseStatistics(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_statistics");
        Integer month = result.getInt("dt_month");
        Integer year = result.getInt("dt_year");
        Double budge = result.getDouble("vl_budge");
        Double cost = result.getDouble("vl_cost");
        Double economy = result.getDouble("vl_economy");

        return new Statistic(id, month, year, budge, cost, economy);
    }
}
