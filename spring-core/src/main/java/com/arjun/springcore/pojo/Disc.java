package com.arjun.springcore.pojo;

public class Disc extends Product {
    private int capacity;

    public Disc() {
    }

    public Disc(String name, double price) {
        super(name, price);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Disc{" +
                "capacity=" + capacity +
                "} " + super.toString();
    }

/*    @Override
    public String toString() {
        return "Disc{" +
                "capacity=" + capacity +
                '}';
    }*/
}
