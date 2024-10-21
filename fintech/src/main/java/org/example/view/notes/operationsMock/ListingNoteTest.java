package org.example.view.notes.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.model.Note;

import java.util.List;

import static org.example.factory.notes.NotesFactory.getNotesDao;

public class ListingNoteTest {

    public static void main(String[] args) {
        try {
            List<Note> notes = getNotesDao().getAll();

            for (Note note : notes) {
                System.out.println(note.getCode() + " - " + note.getNote() + ", " + note.getTitle());
            }

            getNotesDao().closeConnection();
        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }
}
