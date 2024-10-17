package org.example.dao.notes;

import br.com.fiap.model.Note;

import java.sql.SQLException;
import java.util.List;

public interface NotesDao {
    void insert(Note note, Long id);
    Note getById(Long id);
    List<Note> getAll();
    //    void update(Account accounts, Long id);
//    void remove(Long id);
    void closeConnection() throws SQLException;
}
