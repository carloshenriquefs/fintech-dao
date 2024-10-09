package org.example.view;

import org.example.dao.UsuarioDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Usuario;

import java.sql.SQLException;

public class PesquisarUsuarioPorIdView {

    public static void main(String[] args) {
        try {
            UsuarioDao dao = new UsuarioDao();
            Usuario usuario = dao.pesquisar(2);
            System.out.println(usuario.getCodigo() + " - " + usuario.getNome() + ", " + usuario.getSobrenome() + ", " + usuario.getEmail());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Código não existe na tabela");
        }
    }
}
