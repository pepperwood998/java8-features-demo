package com.tuan.exercise.java8.model;

import java.time.LocalDate;
import java.util.Random;

public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Mentor mentor;
    private int skillPoint;

    public Student(String firstName, String lastName, LocalDate dob, Mentor mentor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.mentor = mentor;
        this.skillPoint = new Random().nextInt(100);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[")
        .append("Name=").append(String.format("%s %s", this.firstName, this.lastName)).append(", ")
        .append("Skill=").append(this.skillPoint).append(", ")
        .append("Dob=").append(this.dob)
        .append("]");

        return sb.toString();
    }
}
