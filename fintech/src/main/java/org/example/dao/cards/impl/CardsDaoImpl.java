package org.example.dao.cards.impl;

import br.com.fiap.dao.cards.CardsDao;
import br.com.fiap.exception.AppFintechException;
import br.com.fiap.exception.ErrorTypeEnum;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Card;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.constants.Constants.*;

public class CardsDaoImpl implements CardsDao {

    private Connection connection;

    public CardsDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void insert(Card card, Long id) {
        try {
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO tb_fth_cards (" +
                            "cd_card, " +
                            "cd_user, " +
                            "nm_card, " +
                            "nm_flag, " +
                            "dt_validate, " +
                            "vl_balance) " +
                            "VALUES (seq_card.nextval, ?, ?, ?, ?, ?)");

            stm.setLong(1, id);
            stm.setString(2, card.getNumberCard());
            stm.setString(3, card.getFlag());
            stm.setDate(4, Date.valueOf(card.getValidate()));
            stm.setDouble(5, card.getBalance());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.err.println(ERROR_REGISTERING_CARD + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_INSERTING_DATA);
        }
    }

    @Override
    public Card getById(Long id) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_cards WHERE cd_card = ?");
            stm.setLong(1, id);
            ResultSet result = stm.executeQuery();

            if (!result.next())
                throw new AppFintechException(CARDS_NOT_FOUND + id, null, ErrorTypeEnum.ERROR_SEARCHING_DATA);

            return parseCards(result);

        } catch (SQLException e) {
            System.err.println(ERROR_LOOKING_UP_CARD_ID + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public List<Card> getAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_cards");
            ResultSet result = stm.executeQuery();

            List<Card> lista = new ArrayList<>();

            while (result.next()) {
                lista.add(parseCards(result));
            }

            return lista;

        } catch (SQLException e) {
            System.err.println(ERROR_LISTING_CARDS + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Card parseCards(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_user");
        String card = result.getString("nm_card");
        String flag = result.getString("nm_flag");
        LocalDate validate = result.getDate("dt_validate").toLocalDate();
        Double balance = result.getDouble("vl_balance");

        return new Card(id, card, flag, validate, balance);
    }
}
