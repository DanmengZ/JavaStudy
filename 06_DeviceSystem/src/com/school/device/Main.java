package com.school.device;

public class Main {
    public static void main() {
        Device computer = new Computer("001","my laptop");
        Device printer = new Printer("002", "my printer");
        Device projector = new Projector("003", "my projector");
        showDevice(computer);
        showDevice(printer);
        showDevice(projector);
    }

    public static void showDevice(Device device){
        System.out.println(device.getNumber());
        System.out.println(device.getName());
        device.start();
    }

    public static void connectDevice(NetworkDevice device){

    }
}
