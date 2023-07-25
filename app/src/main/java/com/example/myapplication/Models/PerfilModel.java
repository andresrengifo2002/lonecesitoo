package com.example.myapplication.Models;

public class PerfilModel {

    private int id;
    private String username;
    private String first_name;
    private String last_name;
    private String email;

    public PerfilModel(int id, String username, String first_name, String last_name, String email) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public PerfilModel() {

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFullName() { return first_name + ' ' + last_name;}

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id= " + id +
                "username= " + username +
                "first_name= " + first_name +
                "last_name " + last_name +
                "email= " + email;
    }
}