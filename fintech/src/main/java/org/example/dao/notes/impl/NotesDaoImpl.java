package org.example.dao.notes.impl;

import org.example.dao.notes.NotesDao;
import org.example.exception.EntityNotFoundException;
import org.example.factory.ConnectionFactory;
import org.example.model.Notes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.Constants.NOTES_NOT_FOUND;

public class NotesDaoImpl implements NotesDao {

    private Connection connection;

    public NotesDaoImpl() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void register(Notes notes) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "INSERT INTO tb_fth_notes (" +
                        "cd_notes, " +
                        "cd_user, " +
                        "ds_title, " +
                        "ds_comentary, " +
                        "dt_note) " +
                        "VALUES (seq_user.nextval, ?, ?, ?, ?)");

        stm.setLong(1, notes.getCodeUser());
        stm.setString(2, notes.getTitle());
        stm.setString(3, notes.getComentary());
        stm.setDate(4, Date.valueOf(notes.getNote()));

        stm.executeUpdate();
    }

    public Notes lookUp(long codigo) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_notes WHERE cd_user = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new EntityNotFoundException(NOTES_NOT_FOUND);

        return parseUser(result);
    }

    public List<Notes> list() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM tb_fth_notes");
        ResultSet result = stm.executeQuery();
        List<Notes> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(parseUser(result));
        }

        return lista;
    }

    public void update(Notes notes) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(
                "UPDATE tb_fth_notes " +
                        "SET cd_user = ?, " +
                        "ds_title = ?, " +
                        "ds_comentary = ?, " +
                        "dt_note = ? " +
                        "WHERE cd_user = ?"
        );

        stm.setLong(1, notes.getCodeUser());
        stm.setString(2, notes.getTitle());
        stm.setString(3, notes.getComentary());
        stm.setDate(4, Date.valueOf(notes.getNote()));

        stm.executeUpdate();
    }

    public void remove(long codigo) throws SQLException, EntityNotFoundException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM tb_fth_notes WHERE cd_user = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException(NOTES_NOT_FOUND);
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Notes parseUser(ResultSet result) throws SQLException {
        Long id = result.getLong("cd_user");
        String title = result.getString("ds_title");
        String comentary = result.getString("ds_comentary");
        LocalDate budge = result.getDate("dt_note").toLocalDate();

        return new Notes(id, title, comentary, budge);
    }
}
