package org.example.dao.notes;

import org.example.model.Note;

import java.sql.SQLException;
import java.util.List;

public interface NotesDao {
    void insert(Note note, Long id);
    Note getById(Long id);
    List<Note> getAll();
    void closeConnection() throws SQLException;
}
