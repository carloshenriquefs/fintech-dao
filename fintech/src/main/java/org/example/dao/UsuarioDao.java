package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {

    private Connection connection;

    public UsuarioDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void cadastrar(Usuario usuario) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO tb_fth_usuario (cd_usuario, nm_primeiro, nm_ultimo, email, cd_senha) VALUES (seq_usuario.nextval, ?, ?, ?, ?)");
        stm.setString(1, usuario.getNome());
        stm.setString(2, usuario.getSobrenome());
        stm.setString(3, usuario.getEmail());
        stm.setString(4, usuario.getSenha());
        stm.executeUpdate();
    }

    public void fecharConexao() throws SQLException {
        connection.close();
    }
}
