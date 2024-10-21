package org.example.view.notes.operationsMock;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;
import org.example.model.Note;

import static org.example.factory.notes.NotesFactory.getNotesDao;

public class GetByIdNoteTest {

    public static void main(String[] args) {
        try {

            Note note = getNotesDao().getById(3L);

            System.out.println(note.getNote() + " - " + note.getNote() + ", " + note.getComentary());

            getNotesDao().closeConnection();

        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }
}
