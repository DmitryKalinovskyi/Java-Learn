package com.education.ztu.game;

import java.util.Objects;

public abstract class Participant implements Cloneable {
    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Participant clone() {
        try {
            Participant clone = (Participant) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Participant)
            return o.hashCode() == this.hashCode();

        return false;
    }

    @Override
    public String toString() {
        return "Participant - " + name + " of age: " + age;
    }
}
