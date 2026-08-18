package com.school.device;

public abstract class Device {
    private final String number;
    private String name;

    public Device(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void start();

}


