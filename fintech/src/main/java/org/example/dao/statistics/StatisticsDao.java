package org.example.dao.statistics;

import org.example.exception.EntityNotFoundException;
import org.example.model.Statistics;

import java.sql.SQLException;
import java.util.List;

public interface StatisticsDao {

    void register(Statistics statistics) throws SQLException;
    Statistics lookUp(long codigo) throws SQLException, EntityNotFoundException;
    List<Statistics> list() throws SQLException;
    void update(Statistics statistics) throws SQLException;
    void remove(long codigo) throws  SQLException, EntityNotFoundException;
    void closeConnection() throws SQLException;

}
