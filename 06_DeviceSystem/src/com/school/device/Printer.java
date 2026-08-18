package com.school.device;

public class Printer extends Device implements NetworkDevice{
    public Printer(String number, String name){
        super(number, name);
    }

    @Override
    public void start() {
        System.out.println("Printer starts!");
    }

    @Override
    public void connect(){
        System.out.println("Printer connects to network!");
    }
}
