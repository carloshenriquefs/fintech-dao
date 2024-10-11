package org.example.dao.users;

import org.example.exception.EntidadeNaoEncontradaException;
import org.example.factory.ConnectionFactory;
import org.example.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.USER_NOT_FOUND;

public class UsersDao {

    private Connection connection;

    public UsersDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(User user) throws SQLException {
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
                        "VALUES (seq_user.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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
    }

    public User pesquisar(long codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_user WHERE cd_user = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntidadeNaoEncontradaException(USER_NOT_FOUND);

        return parseUsuario(result);
    }

    public List<User> listar() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_user");
        ResultSet result = stm.executeQuery();
        List<User> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(parseUsuario(result));
        }

        return lista;
    }

    public void atualizar(User user) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "UPDATE tb_fth_user SET nm_first_user = ?, " +
                        "nm_last_user = ?, ds_email = ?, cd_password = ?, " +
                        "ds_address = ?, nr_telephone = ?, ds_gender = ?, " +
                        "ds_position = ?, dt_registration = ? WHERE cd_user = ?"
        );

        stm.setString(1, user.getUsername());
        stm.setString(2, user.getLastName());
        stm.setString(3, user.getEmail());
        stm.setString(4, user.getPassword());
        stm.setString(5, user.getAddress());
        stm.setString(6, user.getTelephone());
        stm.setString(7, user.getGender());
        stm.setString(8, user.getPosition());
        stm.setString(9, user.getDate().toString());
        stm.executeUpdate();
    }

    public void remover(long codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM tb_fth_user WHERE cd_user = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntidadeNaoEncontradaException(USER_NOT_FOUND);
        }
    }

    public void fecharConexao() throws SQLException {
        connection.close();
    }

    private User parseUsuario(ResultSet result) throws SQLException {
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

