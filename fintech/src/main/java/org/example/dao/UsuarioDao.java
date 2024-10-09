package org.example.dao;

import org.example.exception.EntidadeNaoEncontradaException;
import org.example.factory.ConnectionFactory;
import org.example.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Usuario pesquisar(long codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_usuario WHERE cd_usuario = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntidadeNaoEncontradaException("Usuário não encontrado!");

        return parseUsuario(result);
    }

    public List<Usuario> listar() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_usuario");
        ResultSet result = stm.executeQuery();
        List<Usuario> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(parseUsuario(result));
        }

        return lista;
    }

    private Usuario parseUsuario(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_usuario");
        String nome = result.getString("nm_primeiro");
        String sobrenome = result.getString("nm_ultimo");
        String email = result.getString("email");
        String senha = result.getString("cd_senha");
        return new Usuario(id, nome, sobrenome, email, senha);
    }
}
