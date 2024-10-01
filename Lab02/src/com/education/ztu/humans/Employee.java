package com.education.ztu.humans;

import com.education.ztu.car.Car;

public class Employee extends Person{
    protected static int counter = 0;
    private Car car;
    private String position;
    private String company;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Employee(){
        car = null;
        position = "";
        company = "";
        counter++;
    }
    public Employee(Car car, String position, String company){
        this.car = car;
        this.position = position;
        this.company = company;
        counter++;
    }

    public Employee(String firstname, String lastname, int age, Gender gender, Location location, Car car, String position, String company) {
        super(firstname, lastname, age, gender, location);
        this.car = car;
        this.position = position;
        this.company = company;
        counter++;
    }

    @Override
    public String getOccupation(){
        return String.format("Working as %s at %s%n", position, company);
    }

    public static void showCounter(){
        System.out.println(counter);
    }

    @Override
    public String getFullInfo() {
        return super.getFullInfo() + String.format(" Currently working as %s at %s company", position, company);
    }
}
