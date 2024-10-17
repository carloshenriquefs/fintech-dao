package org.example.dao.users.impl;

import br.com.fiap.dao.users.UsersDao;
import br.com.fiap.exception.AppFintechException;
import br.com.fiap.exception.ErrorTypeEnum;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.constants.Constants.*;

public class UsersDaoImpl implements UsersDao {

    private Connection connection;

    public UsersDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }
    @Override
    public void insert(User user) {
        try {
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO tb_fth_user (" +
                            "cd_user, " +
                            "nm_first_user, " +
                            "nm_last_user, " +
                            "ds_email, " +
                            "cd_password, " +
                            "ds_address, " +
                            "nr_telephone, " +
                            "ds_gender, " +
                            "ds_position, " +
                            "dt_registration) " +
                            "VALUES (seq_users.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stm.setString(1, user.getUsername());
            stm.setString(2, user.getLastName());
            stm.setString(3, user.getEmail());
            stm.setString(4, user.getPassword());
            stm.setString(5, user.getAddress());
            stm.setString(6, user.getTelephone());
            stm.setString(7, user.getGender());
            stm.setString(8, user.getPosition());
            stm.setDate(9, Date.valueOf(user.getDate()));

            stm.executeUpdate();

        } catch (SQLException e) {
            System.err.println(ERROR_REGISTERING_USER + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_INSERTING_DATA);
        }
    }

    @Override
    public User getById(Long id) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_user WHERE cd_user = ?");
            stm.setLong(1, id);
            ResultSet result = stm.executeQuery();

            if (!result.next())
                throw new AppFintechException(USER_NOT_FOUND + id, null, ErrorTypeEnum.ERROR_SEARCHING_DATA);

            return parseUser(result);

        } catch (SQLException e) {
            System.err.println(ERROR_LOOKING_UP_USER_ID + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_user");
            ResultSet result = stm.executeQuery();

            List<User> lista = new ArrayList<>();

            while (result.next()) {
                lista.add(parseUser(result));
            }

            return lista;

        } catch (SQLException e) {
            System.err.println(ERROR_LISTING_USERS + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private User parseUser(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_user");
        String firstUser = result.getString("nm_first_user");
        String lastUser = result.getString("nm_last_user");
        String email = result.getString("ds_email");
        String password = result.getString("cd_password");
        String address = result.getString("ds_address");
        String telephone = result.getString("nr_telephone");
        String gender = result.getString("ds_gender");
        String position = result.getString("ds_position");
        LocalDate registration = result.getDate("dt_registration").toLocalDate();

        return new User(id, firstUser, lastUser, email, password, address, telephone, gender, position, registration);
    }
}
