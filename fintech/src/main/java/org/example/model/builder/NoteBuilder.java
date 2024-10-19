package org.example.model.builder;

import org.example.model.Note;

import java.time.LocalDate;

public class NoteBuilder {

    private Long code;
    private Long userId;
    private String title;
    private String comentary;
    private LocalDate note;

    public NoteBuilder setCode(Long code) {
        this.code = code;
        return this;
    }

    public NoteBuilder setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public NoteBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public NoteBuilder setComentary(String comentary) {
        this.comentary = comentary;
        return this;
    }

    public NoteBuilder setNote(LocalDate note) {
        this.note = note;
        return this;
    }

    public Note build() {
        return new Note(code, userId, title, comentary, note);
    }

}
