package com.tuan.exercise.java8.model;

public class Mentor {

    private String firstName;
    private String lastName;
    private long dob;

    public Mentor(String firstName, String lastName, long dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
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

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }
    
    @Override
    public String toString() {
        
        return String.format("[%s %s]", this.firstName, this.lastName);
    }
}
