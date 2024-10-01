package com.education.ztu.humans;

import com.education.ztu.car.Car;

public class Teacher extends Person{
    protected static int counter = 0;
    private Car car;
    private String university;
    private String subject;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher(){
        car = null;
        university = "";
        subject = "";
        counter++;
    }
    public Teacher(Car car, String university, String subject){
        this.car = car;
        this.university = university;
        this.subject = subject;
        counter++;
    }

    public Teacher(String firstname, String lastname, int age, Gender gender, Location location, Car car, String university, String subject) {
        super(firstname, lastname, age, gender, location);
        this.car = car;
        this.university = university;
        this.subject = subject;
        counter++;
    }

    @Override
    public String getOccupation(){
        return String.format("Teaching %s at %s%n", subject, university);
    }

    public static void showCounter(){
        System.out.println(counter);
    }
    @Override
    public String getFullInfo() {
        return super.getFullInfo() + String.format(" Currently teaching %s at %s university", subject, university);
    }
}
