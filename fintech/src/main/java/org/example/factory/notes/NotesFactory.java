package org.example.factory.notes;

import org.example.dao.notes.NotesDao;
import org.example.dao.notes.impl.NotesDaoImpl;
import org.example.model.Notes;
import org.example.model.builder.NotesBuilder;

import java.sql.SQLException;
import java.time.LocalDate;

public class NotesFactory {

    public static NotesDao getNotesDao() throws SQLException {
        return new NotesDaoImpl();
    }

    public static Notes createNotes() {
        return new NotesBuilder()
                .setCode(1L)
                .setCodeUser(1L)
                .setTitle("Pagamento Em Debito")
                .setComentary("Pagamento Efetuado")
                .setNote(LocalDate.of(2021, 06, 25))
                .build();
    }
}
