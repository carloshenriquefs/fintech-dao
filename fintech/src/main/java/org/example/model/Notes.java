package org.example.model;

import java.time.LocalDate;

public class Notes {

    private Long code;
    private Long codeUser;
    private String title;
    private String comentary;
    private LocalDate note;

    public Notes() {
    }

    public Notes(Long codeUser, String title, String comentary, LocalDate note) {
        this.codeUser = codeUser;
        this.title = title;
        this.comentary = comentary;
        this.note = note;
    }

    public Notes(Long code, Long codeUser, String title, String comentary, LocalDate note) {
        this.code = code;
        this.codeUser = codeUser;
        this.title = title;
        this.comentary = comentary;
        this.note = note;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(Long codeUser) {
        this.codeUser = codeUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComentary() {
        return comentary;
    }

    public void setComentary(String comentary) {
        this.comentary = comentary;
    }

    public LocalDate getNote() {
        return note;
    }

    public void setNote(LocalDate note) {
        this.note = note;
    }
}
