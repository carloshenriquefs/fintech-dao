package org.example.view.notes.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.factory.notes.NotesFactory;
import org.example.model.Note;

import static org.example.constants.Constants.NOTES_REGISTERED;
import static org.example.factory.notes.NotesFactory.getNotesDao;

public class RegistrationNoteTest {

    public static void main(String[] args) {
        try {
            Note notes = NotesFactory.createNotes();
            getNotesDao().insert(notes, 2L);
            getNotesDao().closeConnection();
            System.out.println(NOTES_REGISTERED);
        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_INSERTING_DATA);
        }
    }
}
