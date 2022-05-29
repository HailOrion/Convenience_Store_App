package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Cashier extends Person implements CashierInterface, StoreInterface, AvailableProducts {
    private String productName;
    private double productPrice;

    private int productQuantity;

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Cashier(String name, int age, String phoneNumber, String emailAddress) {
        super(name, age, phoneNumber, emailAddress);
    }

    public Cashier(String productName, double productPrice, String chatter) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Cashier(String name, int age, String phoneNumber, String emailAddress, String productName, double productPrice, String chatter) {
        super(name, age, phoneNumber, emailAddress);
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Cashier() {

    }

    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public double getProductPrice() {

        return productPrice;
    }

    public void setProductPrice(double productPrice) {

        this.productPrice = productPrice;
    }

//    public static HashMap<String, Double> productList = new HashMap<String, Double>();


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

//            System.out.println(realStoreList);
//            System.out.println(quantityOfAvailableProducts);

            br.close();
        } catch (Exception ignored) {
        }
    }

    @Override
    public String sellProducts(double customerAmount, String nameOfProduct, double productPrice, int productQuantity) {
        String chatter = null;
        for (int i = 0; i < realStoreList.size(); i++) {
            for (int j = 0; j < realStoreList.get(i).size(); j++) {
                if (productQuantity != 0) {
                    if ((customerAmount >= productPrice)) {
                        if (realStoreList.get(1).get(1).contains(nameOfProduct) ||
                                realStoreList.get(2).get(1).contains(nameOfProduct) ||
                                realStoreList.get(3).get(1).contains(nameOfProduct) ||
                                realStoreList.get(4).get(1).contains(nameOfProduct)) {
                            chatter = nameOfProduct + " " + "is available. " +
                                    "Customer has successfully purchased " + nameOfProduct + ". " +
                                    "Issue receipt";
                        } else {
                            chatter = "Product is unavailable";
                        }
                    } else {
                        chatter = "Customer has insufficient amount!";
                    }
                } else {
                    chatter = "Product is out of stock";
                }
            }
        }
        return chatter;
    }
}
