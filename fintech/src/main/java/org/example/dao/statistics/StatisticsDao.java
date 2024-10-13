package org.example.dao.statistics;

import org.example.exception.EntidadeNaoEncontradaException;
import org.example.factory.ConnectionFactory;
import org.example.model.Statistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.STATISTICS_NOT_FOUND;

public class StatisticsDao {

    private Connection connection;

    public StatisticsDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(Statistics statistics) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO tb_fth_statistics (cd_statistics, cd_user, dt_month, dt_year, vl_budge, vl_cost, vl_economy) VALUES (seq_user.nextval, ?, ?, ?, ?, ?, ?)");
        stm.setLong(1, statistics.getUserCode());
        stm.setInt(2, statistics.getMonth());
        stm.setInt(3, statistics.getYear());
        stm.setDouble(4, statistics.getBudge());
        stm.setDouble(5, statistics.getCost());
        stm.setDouble(6, statistics.getEconomy());
        stm.executeUpdate();
    }

    public void fecharConexao() throws SQLException {
        connection.close();
    }

    public Statistics pesquisar(long codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_statistics WHERE cd_user = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntidadeNaoEncontradaException(STATISTICS_NOT_FOUND);

        return parseUsuario(result);
    }

    public List<Statistics> listar() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_statistics");
        ResultSet result = stm.executeQuery();
        List<Statistics> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(parseUsuario(result));
        }

        return lista;
    }

    public void atualizar(Statistics statistics) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "UPDATE tb_fth_statistics SET cd_user = ?, dt_month = ?, " +
                        "dt_year = ?, vl_budge = ?, vl_cost = ?, " +
                        "cl_economy = ? WHERE cd_user = ?"
        );

        stm.setLong(1, statistics.getUserCode());
        stm.setInt(2, statistics.getMonth());
        stm.setInt(3, statistics.getYear());
        stm.setDouble(4, statistics.getBudge());
        stm.setDouble(5, statistics.getCost());
        stm.setDouble(6, statistics.getEconomy());

        stm.executeUpdate();
    }

    public void remover(long codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM tb_fth_statistics WHERE cd_user = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntidadeNaoEncontradaException(STATISTICS_NOT_FOUND);
        }
    }

    private Statistics parseUsuario(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_user");
        Integer month = result.getInt("dt_month");
        Integer year = result.getInt("dt_year");
        Double budge = result.getDouble("vl_budge");
        Double cost = result.getDouble("vl_cost");
        Double economy = result.getDouble("vl_economy");

        return new Statistics(id, month, year, budge, cost, economy);
    }
}
