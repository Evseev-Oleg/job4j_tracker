package ru.job4j.oop;

public class Lead {
    public static void main(String[] args) {
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle plain1 = new Plain();
        Vehicle plain2 = new Plain();
        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = bus1;
        vehicles[1] = bus2;
        vehicles[2] = train1;
        vehicles[3] = train2;
        vehicles[4] = plain1;
        vehicles[5] = plain2;
        for (Vehicle veh : vehicles
        ) {
            veh.move();
        }
    }
}
