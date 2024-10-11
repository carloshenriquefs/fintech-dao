package org.example.model;

import java.time.LocalDate;

public class User {

    private Long code;
    private String username;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String telephone;
    private String gender;
    private String position;
    private LocalDate date;

    public User() {
    }

    public User(String username, String lastName, String email, String password, String address, String telephone, String gender, String position, LocalDate date) {
        this.username = username;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.telephone = telephone;
        this.gender = gender;
        this.position = position;
        this.date = date;
    }

    public User(Long code, String username, String lastName, String email, String password, String address, String telephone, String gender, String position, LocalDate date) {
        this.code = code;
        this.username = username;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.telephone = telephone;
        this.gender = gender;
        this.position = position;
        this.date = date;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
