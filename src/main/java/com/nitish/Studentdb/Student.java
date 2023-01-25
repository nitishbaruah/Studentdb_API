package com.nitish.Studentdb;

public class Student {
    private int enrollNo;
    private String name;
    private int age;
    private String country;

    // ************** Constructor ************
    public Student(int enrollNo, String name, int age, String country) {
        this.enrollNo = enrollNo;
        this.name = name;
        this.age = age;
        this.country = country;
    }
    /// ******************getter and setter************
    public int getEnrollNo() {
        return enrollNo;
    }

    public void setEnrollNo(int enrollNo) {
        this.enrollNo = enrollNo;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
