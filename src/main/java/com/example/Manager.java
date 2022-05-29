package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static com.example.IntervieweeInterface.applicantList;

public class Manager extends Person implements ManagerInterface, StoreInterface, AvailableProducts {

    private List<String> listOfApplicants =  new ArrayList<>();
    private List<String> hiredCashier =  new ArrayList<>();
    private List<String> hiredAssistantManager =  new ArrayList<>();

    public Manager() {
    }

    public Manager(String name, int age, String phoneNumber, String emailAddress) {
        super(name, age, phoneNumber, emailAddress);
    }

    public Manager(List<String> listOfApplicants, List<String> hiredCashier, List<String> hiredAssistantManager) {
        this.listOfApplicants = listOfApplicants;
        this.hiredCashier = hiredCashier;
        this.hiredAssistantManager = hiredAssistantManager;
    }

    public Manager(String name, int age, String phoneNumber, String emailAddress, String qualifications, List<String> listOfApplicants, List<String> hiredCashier, List<String> hiredAssistantManager) {
        super(name, age, phoneNumber, emailAddress, qualifications);
        this.listOfApplicants = listOfApplicants;
        this.hiredCashier = hiredCashier;
        this.hiredAssistantManager = hiredAssistantManager;
    }

    public Manager(String name, int age, String phoneNumber, String emailAddress, List<String> listOfApplicants, List<String> hiredCashier, List<String> hiredAssistantManager) {
        super(name, age, phoneNumber, emailAddress);
        this.listOfApplicants = listOfApplicants;
        this.hiredCashier = hiredCashier;
        this.hiredAssistantManager = hiredAssistantManager;
    }


    //    @Override
//    public String toString() {
//        return "Manager{" +
//                "listOfApplicant=" + listOfApplicant +
//                '}';
//    }


    @Override
    public void shelf() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "/Users/decagon/IdeaProjects/Convenience Store/src/main/resources/Store products7 - Sheet1.csv"));
            String s;
            while ((s = br.readLine()) != null) {
//                System.out.println(s);

                String[]storeList = s.split(",");
//                for (String index : parts) {
//                    System.out.printf("%-10s", index);
//                }
//                System.out.println();

                realStoreList.add(List.of(storeList));
            }

            quantityOfAvailableProducts.put(realStoreList.get(1).get(1), realStoreList.get(1).get(4));
            quantityOfAvailableProducts.put(realStoreList.get(2).get(1), realStoreList.get(2).get(4));
            quantityOfAvailableProducts.put(realStoreList.get(3).get(1), realStoreList.get(3).get(4));
            quantityOfAvailableProducts.put(realStoreList.get(4).get(1), realStoreList.get(4).get(4));

            System.out.println(realStoreList);
            System.out.println(quantityOfAvailableProducts);

            br.close();
        } catch (Exception ignored) {
        }
    }

    @Override
    public String hireCashier(Interviewee applicant) {
        String feedback = null;
        for (int i = 0; i < applicantList.size(); i++) {
            if(applicant.getAge() >= 21) {
                if (applicant.getQualifications().contains("first class") ||
                        applicant.getQualifications().contains("second class") ||
                        applicant.getQualifications().contains("upper credit")) {
                    if(applicant.getPosition().equals("cashier")) {
                        feedback = "Manager has successfully hired " + applicant.getName() + " as the new " +
                                applicant.getPosition() + ".";
                        hiredCashier.add(applicant.getName());

                    } else if (applicant.getPosition().equals("assistant manager")) {
                        feedback = "Manager has successfully hired " + applicant.getName() + " as the new " +
                                applicant.getPosition() + ".";
                        hiredAssistantManager.add(applicant.getName());
                    } else {
                        feedback = "Please select from the available positions.";
                    }
                } else {
                    feedback = "Sorry" + applicant.getName() +
                            ", we regret to inform you that your application has been denied.";
                }
            } else {
                feedback = "Applicants must be over the age of 20.";
            }
        }
        return feedback;
    }
}