package com.education.ztu.humans;

public abstract class Person implements Human{
    private String firstname;
    private String lastname;
    private int age;
    private Gender gender;
    private Location location;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person(){
        firstname = "";
        lastname = "";
        age = 0;
        gender = Gender.MALE;
        location = Location.KIEV;
    }

    public Person(String firstname, String lastname, int age, Gender gender, Location location ){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    public abstract String getOccupation();

    @Override
    public void sayAge() {
        System.out.printf("My age is %s%n", age);
    }

    @Override
    public void sayGender() {
        System.out.printf("My gender is %s%n", gender.toString());
    }

    @Override
    public void sayLocation() {
        System.out.printf("My location is %s%n", location.toString());
    }

    @Override
    public void sayName() {
        System.out.printf("My name is %s%n", firstname);
    }

    @Override
    public void whoIAm() {
        System.out.printf("I am %s %s%n", firstname, lastname);
    }

    @Override
    public String getFullInfo() {
        return String.format("I am person with name %s %s. I live in %s.", firstname, lastname, location.toString());
    }
}
