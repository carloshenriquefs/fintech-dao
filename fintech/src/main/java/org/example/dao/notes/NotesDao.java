package org.example.dao.notes;

import org.example.exception.EntityNotFoundException;
import org.example.model.Notes;

import java.util.List;
import java.sql.SQLException;

public interface NotesDao {

    void register(Notes notes) throws SQLException;
    Notes lookUp(long codigo) throws SQLException, EntityNotFoundException;
    List<Notes> list() throws SQLException;
    void update(Notes notes) throws SQLException;
    void remove(long codigo) throws SQLException, EntityNotFoundException;
    void closeConnection() throws SQLException;

}
