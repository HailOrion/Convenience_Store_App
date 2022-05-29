package com.example;

//import static com.example.StoreInterface.storeList;

public class Main {
    public static void main(String[] args) {
        // Instantiating manager class
        Manager az = new Manager();
        az.setName("Abdulazeez Olafimihan");
        az.shelf();

        // Instantiating Interviewee class
        Interviewee lanre = new Interviewee();
        lanre.setName("Lanre Ogunremi");
        lanre.setAge(29);
        lanre.setQualifications("B.Sc, second class upper");
        lanre.setPosition("cashier");


        Interviewee dave = new Interviewee();
        dave.setName("David Baba");
        dave.setAge(32);
        dave.setQualifications("HND upper credit");
        dave.setPosition("assistant manager");

        System.out.println(lanre.apply(lanre, az));
        System.out.println(dave.apply(dave,az));
        System.out.println(az.hireCashier(lanre));
        System.out.println(az.hireCashier(dave));

        Cashier lanreO = new Cashier();
        lanreO.setName("Lanre Ogunremi");
//        System.out.println(lanreO.shelf());
        System.out.println(lanreO.sellProducts(9000, "Granola", 3000, 1));

        Customer josh = new Customer();
        josh.setName("Joshua Adeyemo");
        System.out.println(josh.buyProducts(9000, "Granola", 7000, 20));
    }
}
