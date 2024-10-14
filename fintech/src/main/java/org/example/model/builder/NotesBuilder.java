package org.example.model.builder;

import org.example.model.Notes;

import java.time.LocalDate;

public class NotesBuilder {

    private Long code;
    private Long codeUser;
    private String title;
    private String comentary;
    private LocalDate note;

    public NotesBuilder setCode(Long code) {
        this.code = code;
        return this;
    }

    public NotesBuilder setCodeUser(Long codeUser) {
        this.codeUser = codeUser;
        return this;
    }

    public NotesBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public NotesBuilder setComentary(String comentary) {
        this.comentary = comentary;
        return this;
    }

    public NotesBuilder setNote(LocalDate note) {
        this.note = note;
        return this;
    }

    public Notes build() {
        return new Notes(code, codeUser, title, comentary, note);
    }
}
