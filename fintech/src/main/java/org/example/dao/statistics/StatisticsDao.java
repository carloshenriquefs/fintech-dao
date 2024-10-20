package org.example.dao.statistics;

import org.example.model.Statistic;

import java.sql.SQLException;
import java.util.List;

public interface StatisticsDao {

    void insert(Statistic statistic, Long id);
    Statistic getById(Long id);
    List<Statistic> getAll();
    void closeConnection() throws SQLException;
}
