package com.education.ztu.car;

public class CarBattery {
    private int capacity;
    private int charge;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public CarBattery(){
        capacity = 1;
        charge = 0;
    }

    public CarBattery(int charge, int capacity){
        this.capacity = capacity;
        this.charge = charge;
    }

    public boolean isCharged(){
        return charge > 0;
    }

    public void charge(int power){
        charge = Math.min(power + charge, capacity);
    }
}
