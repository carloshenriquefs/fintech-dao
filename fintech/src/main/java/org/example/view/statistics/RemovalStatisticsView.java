package org.example.view.statistics;

import org.example.dao.statistics.StatisticsDao;
import org.example.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

import static org.example.constants.Constants.STATISTICS_NOT_FOUND;
import static org.example.constants.Constants.STATISTICS_REMOVED;

public class RemovalStatisticsView {

    public static void main(String[] args) {
        try {
            StatisticsDao dao = new StatisticsDao();
            dao.remover(3);
            dao.fecharConexao();
            System.out.println(STATISTICS_REMOVED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(STATISTICS_NOT_FOUND);
        }
    }
}
