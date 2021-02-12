package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("I driving");
    }

    @Override
    public void passengers(int number) {
        System.out.println("The bus has " + number + " passengers");

    }

    @Override
    public int refuel(int fuel) {
        int price = fuel * 45;
        return price;
    }
}
