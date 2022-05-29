package com.example;

public abstract class Person {
    private String name;
    private int age;
    private String phoneNumber;
    private String emailAddress;

    private String qualifications;

    public Person() {
    }

    public Person(String name, int age, String phoneNumber, String emailAddress, String qualifications) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.qualifications = qualifications;
    }


    public Person(String name, int age, String phoneNumber, String emailAddress) {
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String person() {
        return name + age + emailAddress + phoneNumber;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", qualifications='" + qualifications + '\'' +
                '}';
    }
}
