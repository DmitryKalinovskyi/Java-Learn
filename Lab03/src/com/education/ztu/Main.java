package com.education.ztu;

import com.education.ztu.game.Schoolar;

public class Main {

    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Ivan", 13);
        Schoolar schoolar3 = new Schoolar("Dmytro", 19);

        System.out.println("Hash code of schoolar1: " + schoolar1.hashCode());
        System.out.println("Hash code of schoolar2: " + schoolar2.hashCode());
        System.out.println("Hash code of schoolar3: " + schoolar3.hashCode());
        if(schoolar1.equals(schoolar2)){
            System.out.println("They equals");
        }
        else{
            System.out.println("They don't equals");
        }

        System.out.println(schoolar1.toString());


    }
}
