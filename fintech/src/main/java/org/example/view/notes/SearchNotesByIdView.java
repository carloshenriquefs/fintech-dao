package org.example.view.notes;

import org.example.dao.notes.NotesDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Notes;

import java.sql.SQLException;

import static org.example.constants.Constants.CODE_NOT_EXIST;

public class SearchNotesByIdView {

    public static void main(String[] args) {
        try {
            NotesDao dao = new NotesDao();
            Notes note = dao.pesquisar(3);
            System.out.println(note.getCodeUser() + " - " + note.getNote() + ", " + note.getComentary());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(CODE_NOT_EXIST);
        }
    }
}
