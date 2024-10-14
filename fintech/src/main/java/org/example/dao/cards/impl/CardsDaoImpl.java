package org.example.dao.cards.impl;

import org.example.dao.cards.CardsDao;
import org.example.exception.EntityNotFoundException;
import org.example.factory.ConnectionFactory;
import org.example.model.Cards;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.CARDS_NOT_FOUND;

public class CardsDaoImpl implements CardsDao {

    private Connection connection;

    public CardsDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void register(Cards cards) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "INSERT INTO tb_fth_cards (" +
                        "cd_card, " +
                        "cd_user, " +
                        "nm_card, " +
                        "nm_flag, " +
                        "dt_validate, " +
                        "vl_balance) " +
                        "VALUES (seq_user.nextval, ?, ?, ?, ?, ?)");

        stm.setLong(1, cards.getCodeUser());
        stm.setString(2, cards.getNumberCard());
        stm.setString(3, cards.getFlag());
        stm.setDate(4, Date.valueOf(cards.getValidate()));
        stm.setDouble(5, cards.getBalance());

        stm.executeUpdate();
    }

    public Cards lookUp(long codigo) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_cards WHERE cd_user = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntityNotFoundException(CARDS_NOT_FOUND);

        return parseUser(result);
    }

    public List<Cards> list() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_cards");
        ResultSet result = stm.executeQuery();
        List<Cards> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(parseUser(result));
        }

        return lista;
    }

    public void update(Cards cards) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "UPDATE tb_fth_cards " +
                        "SET cd_user = ?, " +
                        "nm_card = ?, " +
                        "nm_flag = ?, " +
                        "dt_validate = ?, " +
                        "vl_balance = ? " +
                        "WHERE cd_user = ?"
        );

        stm.setLong(1, cards.getCodeUser());
        stm.setString(2, cards.getNumberCard());
        stm.setString(3, cards.getFlag());
        stm.setString(4, cards.getValidate().toString());
        stm.setDouble(5, cards.getBalance());

        stm.executeUpdate();
    }

    public void remove(long codigo) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM tb_fth_cards WHERE cd_user = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException(CARDS_NOT_FOUND);
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Cards parseUser(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_user");
        String card = result.getString("nm_card");
        String flag = result.getString("nm_flag");
        LocalDate validate = result.getDate("dt_validate").toLocalDate();
        Double balance = result.getDouble("vl_balance");

        return new Cards(id, card, flag, validate, balance);
    }
}
