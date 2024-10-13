package org.example.view.notes;

import org.example.dao.notes.NotesDao;
import org.example.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

import static org.example.constants.Constants.NOTES_NOT_FOUND;
import static org.example.constants.Constants.NOTES_REMOVED;

public class RemovalNotesView {

    public static void main(String[] args) {
        try {
            NotesDao dao = new NotesDao();
            dao.remover(3);
            dao.fecharConexao();
            System.out.println(NOTES_REMOVED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(NOTES_NOT_FOUND);
        }
    }
}
