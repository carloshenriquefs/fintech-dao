package org.example.dao.notes.impl;

import br.com.fiap.dao.notes.NotesDao;
import br.com.fiap.exception.AppFintechException;
import br.com.fiap.exception.ErrorTypeEnum;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Note;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.constants.Constants.*;

public class NotesDaoImpl implements NotesDao {

    private Connection connection;

    public NotesDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }


    @Override
    public void insert(Note note, Long id) {
        try {
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO tb_fth_notes (" +
                            "cd_notes, " +
                            "cd_user, " +
                            "ds_title, " +
                            "ds_comentary, " +
                            "dt_note) " +
                            "VALUES (seq_note.nextval, ?, ?, ?, ?)");

            stm.setLong(1, id);
            stm.setString(2, note.getTitle());
            stm.setString(3, note.getComentary());
            stm.setDate(4, Date.valueOf(note.getNote()));

            stm.executeUpdate();

        } catch (SQLException e) {
            System.err.println(ERROR_REGISTERING_NOTE + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_INSERTING_DATA);
        }
    }

    @Override
    public Note getById(Long id) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_notes WHERE cd_notes = ?");
            stm.setLong(1, id);
            ResultSet result = stm.executeQuery();

            if (!result.next())
                throw new AppFintechException(NOTES_NOT_FOUND + id, null, ErrorTypeEnum.ERROR_SEARCHING_DATA);

            return parseNotes(result);

        } catch (SQLException e) {
            System.err.println(ERROR_LOOKING_UP_NOTE_ID + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public List<Note> getAll() {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_notes");
            ResultSet result = stm.executeQuery();

            List<Note> lista = new ArrayList<>();

            while (result.next()) {
                lista.add(parseNotes(result));
            }

            return lista;

        } catch (SQLException e) {
            System.err.println(ERROR_LISTING_NOTE + e.getMessage());
            throw new AppFintechException(e.getMessage(), e, ErrorTypeEnum.ERROR_SEARCHING_DATA);
        }
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Note parseNotes(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_notes");
        String title = result.getString("ds_title");
        String comentary = result.getString("ds_comentary");
        LocalDate budge = result.getDate("dt_note").toLocalDate();

        return new Note(id, title, comentary, budge);
    }
}
