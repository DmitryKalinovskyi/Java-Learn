package com.education.ztu.car;

public class CarBuilder {
    protected Car car;

    public CarBuilder(){
        car = new Car();
    }

    public CarBuilder setEngine(Engine engine){
        car.setEngine(engine);
        return this;
    }

    public CarBuilder setModel(String model){
        car.setModel(model);
        return this;
    }

    public CarBuilder setCarBattery(CarBattery battery){
        car.setCarBattery(battery);
        return this;
    }

    public CarBuilder setBrand(String brand){
        car.setBrand(brand);
        return this;
    }

    public Car build(){
        return car;
    }
}
