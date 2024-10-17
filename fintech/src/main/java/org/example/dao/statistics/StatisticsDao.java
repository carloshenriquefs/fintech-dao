package org.example.dao.statistics;

import br.com.fiap.model.Statistic;

import java.sql.SQLException;
import java.util.List;

public interface StatisticsDao {

    void insert(Statistic statistic, Long id);
    Statistic getById(Long id);
    List<Statistic> getAll();
    //    void update(Account accounts, Long id);
//    void remove(Long id);
    void closeConnection() throws SQLException;
}
