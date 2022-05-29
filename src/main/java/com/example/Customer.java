package com.example;

public class Customer extends Person implements CustomerInterface, AvailableProducts {
    private double customerAmount;
    private String nameOfProduct;

    private int customerQuantity;

    public int getCustomerQuantity() {
        return customerQuantity;
    }

    public void setCustomerQuantity(int customerQuantity) {
        this.customerQuantity = customerQuantity;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public void setCustomerAmount(double customerAmount) {

        this.customerAmount = customerAmount;
    }

    public double getCustomerAmount() {

        return customerAmount;
    }

    @Override
    public String buyProducts(double customerAmount, String nameOfProduct, double productPrice, int productQuantity) {
        String feedback_2;
        if (productQuantity != 0) {
            if (customerAmount >= productPrice) {
                if (quantityOfAvailableProducts.containsKey(nameOfProduct)) {
                    feedback_2 = "Purchase successful!";
                } else {
                    feedback_2 = "This item is not available at the moment.";
                }
            } else {
                feedback_2 = "You do not have enough money to buy this item.";
            }
        } else {
            feedback_2 = "OUT OF STOCK!";
        }

//        for (int i = 0; i < listOfAvailableProducts.size(); i++) {
//            if (listOfAvailableProducts.toString().toLowerCase().contains(nameOfProduct.toLowerCase())) {
//                feedback_2 = "yes";
//            } else {
//                feedback_2 = "no";
//            }

//            if ((listOfAvailableProducts.toString().contains(nameOfProduct.toLowerCase()) &&
//                    listOfAvailableProducts.toString().equals("0"))) {
//                if (amount >= productPrice) {
//                    feedback_2 = "Purchase successful";
//                } else {
//                    feedback_2 = "You do not have enough money to complete this transaction";
//                }
//            } else {
//                feedback_2 = "OUT OF STOCK!";
//            }

//            if (temp.toLowerCase().contains(nameOfProduct.toLowerCase())) {
//                if (amount >= productPrice) {
//                    feedback_2 = "Purchase successful";
//                } else {
//                    feedback_2 = "Purchase Unsuccessful";
//                }
//            } else {
//                feedback_2 = "OUT OF STOCK!";

        return feedback_2;
    }

}