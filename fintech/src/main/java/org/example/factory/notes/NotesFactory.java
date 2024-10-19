package org.example.factory.notes;

import org.example.dao.notes.NotesDao;
import org.example.dao.notes.impl.NotesDaoImpl;
import org.example.model.Note;
import org.example.model.builder.NoteBuilder;

import java.sql.SQLException;
import java.time.LocalDate;

public class NotesFactory {

    public static NotesDao getNotesDao() throws SQLException {
        return new NotesDaoImpl();
    }

    public static Note createNotes() {
        return new NoteBuilder()
                .setUserId(2L)
                .setTitle("Pagamento Em Debito")
                .setComentary("Pagamento Efetuado")
                .setNote(LocalDate.of(2021, 06, 25))
                .build();
    }
}
