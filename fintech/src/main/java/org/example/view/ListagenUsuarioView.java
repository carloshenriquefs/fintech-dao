package org.example.view;

import org.example.dao.UsuarioDao;
import org.example.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class ListagenUsuarioView {

    public static void main(String[] args) {
        try {
            UsuarioDao dao = new UsuarioDao();
            List<Usuario> usuarios = dao.listar();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.getCodigo() + " - " + usuario.getNome() + ", " + usuario.getSobrenome() + ", " + usuario.getEmail());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
