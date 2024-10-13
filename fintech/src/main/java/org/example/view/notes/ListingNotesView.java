package org.example.view.notes;

import org.example.dao.notes.NotesDao;
import org.example.model.Notes;

import java.sql.SQLException;
import java.util.List;

public class ListingNotesView {

    public static void main(String[] args) {
        try {
            NotesDao dao = new NotesDao();
            List<Notes> notes = dao.listar();
            for (Notes note : notes) {
                System.out.println(note.getCodeUser() + " - " + note.getNote() + ", " + note.getTitle());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
