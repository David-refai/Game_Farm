package com.company.Animal;


import com.company.Food.Food;

import java.io.Serializable;


public abstract class Animal implements Serializable {
    protected int possibleBreed; //number of childrens in one breed
    public int health;
    protected String animalName;
    protected String gender;
    protected int Max_age;
    protected int Age;
    protected double price;
    protected String Type;
    protected int Max_breed;
    protected double healthValue;
    protected boolean sick;
    protected double veterinarian;
    protected boolean treatment;


    public void setHealth(int health) {
        this.health = health;
    }

    public double getVeterinarian() {
        return veterinarian;
    }


    public boolean isTreatment() {
            sick = false;

            return true;
    }



    public Animal(String animalName, String gender) {
        this.health = 100;
        this.Age = 1;
        this.animalName = animalName;
        this.gender = gender;
        this.veterinarian = 300;
        this.treatment = true;
        this.sick = false;
        

    }


    public double getHealthValue() {
        return healthValue;
    }


    public int getPossibleBreed() {
        return possibleBreed;
    }


    public abstract boolean ICanEat(Food food);

    public int getMax_breed() {
        return Max_breed;
    }

    public void decreaseMaxBreed(int m) {
        if (Max_breed != 0) {
            Max_breed -= m;
        }
    }

    public String getType() {
        return Type;
    }


    public String getAnimalName() {
        return this.animalName;
    }


    public void decreaseHealth(int h) {
        health = (health - health * h / 100) - 1;


    }

    public void increaseAge(int a) {
        if (this.Age == Max_age) {
            System.err.println( getAnimalName() + "  He has reached the top of age");
            decreaseHealthValue(a);


        } else {
            Age++;
            price--;

        }
    }

    public void increaseHealthValue(int p) {

        healthValue = ((healthValue + healthValue) * p / 100) + 10;
    }

    public void increaseHealth(int health) {

        this.health += health;
        increaseHealthValue(health);


    }

    public int getHealth() {
        return health;
    }

    public String getGender() {
        return gender;
    }


    public int getAge() {
        return Age;
    }


    public void decreaseHealthValue(int p) {
        if (healthValue != 0)
            healthValue = (int) (healthValue - healthValue * p / 100);
        else
            price = (int) (price - price * p / 100);
    }

    public double getPrice() {
        return price;
    }

    public boolean isLive() {
        if (health != 0)
            return true;
        else
            System.err.println(" I am out ...,the animal is -_- ");
        return false;

    }

    public boolean isSick() {
        return sick;
    }

    public boolean setSick() {

        if (!sick) {
            int breed = (int) (Math.random() * 150) + 1;
            if (breed <= 10 ) {
                if (health < 50)
                    System.err.println(getAnimalName() + "  " + "is sick");
                    return sick = true;

            } else
                return sick = false;
        } else
            System.err.println(getAnimalName() + "  " + "is sick");
            return true;

    }

    public boolean Hungry() {
        if (!setSick() && health < 30) {
            System.err.println(animalName + " is hungry");
            return true;
        }else
        return false;
        }
    }









