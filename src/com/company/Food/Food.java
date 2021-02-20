package com.company.Food;


import java.io.ObjectInputStream;
import java.io.Serializable;

public abstract class Food implements Serializable {

    protected String namesFood;
    private double price;
    public int Kg ;
    private int quantity;
    public Food(String namesFood, int price) {
        Kg = 0;
        this.namesFood = namesFood;
        this.price = price;

    }


    public void setKg(int kg) {
    if (kg >= 1) {

            this.Kg += kg;
        }

else

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
    private void readObject(ObjectInputStream i){

    }
    private void writeObject(ObjectInputStream o){

    }

    }

