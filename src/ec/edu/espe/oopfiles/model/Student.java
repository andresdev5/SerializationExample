package ec.edu.espe.oopfiles.model;

import java.util.Date;

/**
 *
 * @author jon_m
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private double average;
    private boolean hasScholarship;
    
    public Student() {
        id = (int)(Math.random() * (9999)) + 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }
    
    @Override
    public String toString() {
        return String.format(
            "%d;%s;%d;%.2f;%d",
            id, name, age, average, (hasScholarship ? 1 : 0));
    }
}