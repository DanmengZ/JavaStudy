package com.school.device;

public class Computer extends Device implements NetworkDevice{
    public Computer(String number, String name){
        super(number, name);
    }
    @Override
    public void start(){
        System.out.println("computer starts!");
    }
    @Override
    public void connect() {
        System.out.println("computer connects to network!");
    }
}
