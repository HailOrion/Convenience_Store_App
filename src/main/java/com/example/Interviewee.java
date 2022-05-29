package com.example;

import java.util.ArrayList;
import java.util.List;

public class Interviewee extends Person implements IntervieweeInterface{
    private String position;


    public Interviewee() {
    }

    public Interviewee(String position) {
        this.position = position;
    }

    public Interviewee(String name, int age, String phoneNumber, String emailAddress, String qualifications, String position) {
        super(name, age, phoneNumber, emailAddress, qualifications);
        this.position = position;
    }

    public Interviewee(String name, int age, String phoneNumber, String emailAddress, String qualifications) {
        super(name, age, phoneNumber, emailAddress, qualifications);
        this.setQualifications(qualifications);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String apply(Interviewee applicant, Manager manager) {
        String feedback_2;
        if (applicant.getName()!=null && applicant.getAge() >= 21) {
            feedback_2 = applicant.getName() + ", " + "your application has been submitted successfully";
            applicantList.add(applicant);
        } else{
            feedback_2 = applicant.getName() + ", " + "your application was unsuccessful";
        }
//        System.out.println(applicantList);

        return feedback_2;
    }
}
