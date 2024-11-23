package com.education.ztu;

public class Task2 {
    public static void stringTest(String s){
        System.out.println("Last character: " + s.charAt(s.length()-1));
        System.out.println("Is ends with \"!!!\"? " + s.endsWith("!!!"));
        System.out.println("Is starts with \"I learn\"? " + s.startsWith("I learn"));
        System.out.println("Does it contains \"Java\"? " + s.contains("Java"));
        System.out.println("Index of \"Java\"? " + s.indexOf("Java"));
        System.out.println("Replace a to o: " + s.replace('a', 'o'));
        System.out.println("To upper case: " + s.toUpperCase());
        System.out.println("To lower case: " + s.toLowerCase());
        System.out.println("Cut \"Java\" from string: " + s.replace("Java", ""));
    }


    public static void main(String[] args){
        stringTest("I learn Java!!!");
    }
}
