package org.example.view.statistics;

import org.example.dao.statistics.StatisticsDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Statistics;

import java.sql.SQLException;

import static org.example.constants.Constants.STATISTICS_NOT_FOUND;
import static org.example.constants.Constants.STATISTICS_UPDATED;

public class UpdateStatisticsView {

    public static void main(String[] args) {
        try {
            StatisticsDao dao = new StatisticsDao();
            Statistics statistics = dao.pesquisar(2);
            statistics.setMonth(9);
            statistics.setYear(2003);
            statistics.setBudge(1000.0);
            statistics.setCost(100.0);
            statistics.setEconomy(10000.0);
            dao.atualizar(statistics);
            dao.fecharConexao();
            System.out.println(STATISTICS_UPDATED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(STATISTICS_NOT_FOUND);
        }
    }
}
