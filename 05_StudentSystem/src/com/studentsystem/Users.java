package com.studentsystem;

public class Users {
    private String name;
    private String password;
    private String ID;
    private String number;

    public Users(String name, String password, String ID, String number) {
        this.name = name;
        this.password = password;
        this.ID = ID;
        this.number = number;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

