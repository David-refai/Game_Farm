package com.company.Food;



public abstract class Food {
    private String namesFood;
    private double price;
    public int Kg ;
    private int quantity;

    public Food(String namesFood, int price) {
        Kg = 1;
        this.namesFood = namesFood;
        this.price = price;
    }


    public void setKg(int kg) {
    if (kg >= 1) {
        this.Kg *= kg;
}

        System.out.println("You shopped no thing ");
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getKg() {
        return Kg;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getNamesFood() {
        return namesFood;
    }

    public void setPrice(double price) {

            this.price =price;
    }

    public  double getPrice() {

        return this.price * getKg();
    }

    }

