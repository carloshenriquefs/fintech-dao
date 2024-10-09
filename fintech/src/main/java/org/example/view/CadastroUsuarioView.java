package org.example.view;

import org.example.dao.UsuarioDao;
import org.example.model.Usuario;

import java.sql.SQLException;

public class CadastroUsuarioView {

    public static void main(String[] args) {
        try {
            UsuarioDao dao = new UsuarioDao();
            Usuario usuario = new Usuario("Joao", "Souza", "joao.souza@yahoo.com", "0987654321");
            dao.cadastrar(usuario);
            dao.fecharConexao();
            System.out.println("Usuario Cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
