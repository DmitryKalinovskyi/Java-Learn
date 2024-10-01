package com.education.ztu.humans;

public class Student extends Person{
    protected static int counter = 0;
    private int course;
    private String university;
    private String speciality;

    public Student(){
        this(1, "", "");
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Student(int course, String university, String speciality){
        this.course = course;
        this.university = university;
        this.speciality = speciality;
        counter++;
    }

    public Student(String firstname, String lastname, int age, Gender gender, Location location, int course, String university, String speciality) {
        super(firstname, lastname, age, gender, location);
        this.course = course;
        this.university = university;
        this.speciality = speciality;
        counter++;
    }

    @Override
    public String getOccupation(){
        return String.format("Learning %s at %s%n", speciality, university);
    }

    public static void showCounter(){
        System.out.println(counter);
    }

    @Override
    public String getFullInfo() {
        return super.getFullInfo() + String.format(" Currently learning for a %s at %s university (%s year)", speciality, university, course);
    }
}
