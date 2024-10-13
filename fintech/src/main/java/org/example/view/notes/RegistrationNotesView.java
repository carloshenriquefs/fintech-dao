package org.example.view.notes;

import org.example.dao.notes.NotesDao;
import org.example.model.Notes;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.example.constants.Constants.NOTES_REGISTERED;

public class RegistrationNotesView {

    public static void main(String[] args) {
        try {
            NotesDao dao = new NotesDao();
            Notes notes = new Notes(3L, "Pagamento", "Devendo R$300", LocalDate.of(2010, 8, 2));
            dao.cadastrar(notes);
            dao.fecharConexao();
            System.out.println(NOTES_REGISTERED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
