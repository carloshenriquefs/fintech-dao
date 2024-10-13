package org.example.view.notes;

import org.example.dao.notes.NotesDao;
import org.example.exception.EntidadeNaoEncontradaException;
import org.example.model.Notes;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.example.constants.Constants.NOTES_NOT_FOUND;
import static org.example.constants.Constants.NOTES_UPDATED;

public class UpdateNotesView {

    public static void main(String[] args) {
        try {
            NotesDao dao = new NotesDao();
            Notes notes = dao.pesquisar(3);
            notes.setCode(2L);
            notes.setNote(LocalDate.of(2023, 6, 4));
            notes.setComentary("Pagamento realizado");
            notes.setTitle("Pagamento");
            dao.atualizar(notes);
            dao.fecharConexao();
            System.out.println(NOTES_UPDATED);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println(NOTES_NOT_FOUND);
        }
    }
}
