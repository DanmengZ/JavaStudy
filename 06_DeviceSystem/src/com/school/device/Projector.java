package com.school.device;

public class Projector extends Device{
    public Projector(String number,String name){
        super(number, name);
    }
    @Override
    public void start(){
        System.out.println("projector starts!");
    }
}
