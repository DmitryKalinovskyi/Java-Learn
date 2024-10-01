package com.education.ztu.car;

public class Car {
    private String brand;
    private String model;
    private Engine engine;
    private CarBattery carBattery;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarBattery getCarBattery() {
        return carBattery;
    }

    public void setCarBattery(CarBattery carBattery) {
        this.carBattery = carBattery;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Car(){
        brand = "";
    }

    public Car(String brand, String model){
        this.brand = brand;
    }

    public boolean isEngineWorks(){
        return engine.isEngineWorks();
    }

    public void startEngine(){
        engine.startEngine();
        System.out.printf("%s %s engine is started%n", brand, model);
    }

    public void stopEngine(){
        engine.stopEngine();
        System.out.printf("%s %s engine is stop%n", brand, model);
    }
}
