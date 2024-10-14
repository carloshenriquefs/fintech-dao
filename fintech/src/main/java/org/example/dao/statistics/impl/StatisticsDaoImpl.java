package org.example.dao.statistics.impl;

import org.example.dao.statistics.StatisticsDao;
import org.example.exception.EntityNotFoundException;
import org.example.factory.ConnectionFactory;
import org.example.model.Statistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.STATISTICS_NOT_FOUND;

public class StatisticsDaoImpl implements StatisticsDao {

    private Connection connection;

    public StatisticsDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void register(Statistics statistics) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "INSERT INTO tb_fth_statistics (" +
                        "cd_statistics, " +
                        "cd_user, " +
                        "dt_month, " +
                        "dt_year, " +
                        "vl_budge, " +
                        "vl_cost, " +
                        "vl_economy) " +
                        "VALUES (seq_user.nextval, ?, ?, ?, ?, ?, ?)");

        stm.setLong(1, statistics.getUserCode());
        stm.setInt(2, statistics.getMonth());
        stm.setInt(3, statistics.getYear());
        stm.setDouble(4, statistics.getBudge());
        stm.setDouble(5, statistics.getCost());
        stm.setDouble(6, statistics.getEconomy());

        stm.executeUpdate();
    }

    public Statistics lookUp(long codigo) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_statistics WHERE cd_user = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntityNotFoundException(STATISTICS_NOT_FOUND);

        return parseUser(result);
    }

    public List<Statistics> list() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_statistics");
        ResultSet result = stm.executeQuery();
        List<Statistics> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(parseUser(result));
        }

        return lista;
    }

    public void update(Statistics statistics) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "UPDATE tb_fth_statistics " +
                        "SET cd_user = ?, " +
                        "dt_month = ?, " +
                        "dt_year = ?, " +
                        "vl_budge = ?, " +
                        "vl_cost = ?, " +
                        "cl_economy = ? " +
                        "WHERE cd_user = ?"
        );

        stm.setLong(1, statistics.getUserCode());
        stm.setInt(2, statistics.getMonth());
        stm.setInt(3, statistics.getYear());
        stm.setDouble(4, statistics.getBudge());
        stm.setDouble(5, statistics.getCost());
        stm.setDouble(6, statistics.getEconomy());

        stm.executeUpdate();
    }

    public void remove(long codigo) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM tb_fth_statistics WHERE cd_user = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException(STATISTICS_NOT_FOUND);
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Statistics parseUser(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_user");
        Integer month = result.getInt("dt_month");
        Integer year = result.getInt("dt_year");
        Double budge = result.getDouble("vl_budge");
        Double cost = result.getDouble("vl_cost");
        Double economy = result.getDouble("vl_economy");

        return new Statistics(id, month, year, budge, cost, economy);
    }
}
