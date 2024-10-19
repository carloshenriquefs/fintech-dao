package org.example.model;

import java.time.LocalDate;

public class Note {

    private Long code;
    private Long userId;
    private String title;
    private String comentary;
    private LocalDate note;

    public Note(Long code, Long userId, String title, String comentary, LocalDate note) {
        this.code = code;
        this.userId = userId;
        this.title = title;
        this.comentary = comentary;
        this.note = note;
    }

    public Note(Long userId, String title, String comentary, LocalDate note) {
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
