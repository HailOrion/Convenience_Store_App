package com.example;

import java.util.ArrayList;
import java.util.List;

public interface IntervieweeInterface {

    List<Interviewee> applicantList = new ArrayList<>();

    String apply(Interviewee applicant, Manager manager);
}
