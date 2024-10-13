package org.example.view.statistics;

import org.example.dao.statistics.StatisticsDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Statistics;

import java.sql.SQLException;

import static org.example.constants.Constants.CODE_NOT_EXIST;

public class SearchStatisticsByIdView {

    public static void main(String[] args) {
        try {
            StatisticsDao dao = new StatisticsDao();
            Statistics statistics = dao.pesquisar(3);
            System.out.println(statistics.getMonth() + " - " + statistics.getUserCode() + ", " + statistics.getEconomy() + ", " + statistics.getBudge());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(CODE_NOT_EXIST);
        }
    }
}
