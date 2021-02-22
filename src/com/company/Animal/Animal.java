package com.company.Animal;


import com.company.Food.Food;

import java.io.Serializable;


public abstract class Animal implements Serializable {
    protected int possibleBreed; //number of children in one breed
    public int health;
    protected String animalName;
    protected String gender;
    protected int Max_age;
    protected int Age;
    protected double price;
    protected String Type;
    protected int max_breed;
    protected double healthValue;
    protected boolean sick;
    protected double veterinarian;
    protected boolean treatment;





    public Animal(String animalName, String gender) {
        this.health = 100;
        this.Age = 1;
        this.animalName = animalName;
        this.gender = gender;
        this.veterinarian = 300;
        this.treatment = true;
        this.sick = false;
        

    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getVeterinarian() {
        return veterinarian;
    }


    public void isTreatment() {
        sick = false;
    }

    public double getHealthValue() {
        return healthValue;
    }


    public int getPossibleBreed() {
        return possibleBreed;
    }


    public abstract boolean ICanEat(Food food, int kilogram);// Abstract method when every animal can decides their foods

    public int getMax_breed() {
        return max_breed;
    }

    public void decreaseMaxBreed(int m) {
        if (max_breed != 0) {
            max_breed -= m;
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
    public void increaseHealth(int health) {

        this.health += health;
        increaseHealthValue(health);
    }
// Every round the age increases  until the animal reach MAX of age
    public void increaseAge(int a) {
        if (this.Age == Max_age) {
            System.err.println( getAnimalName() + " The animal has reached the top of its age");
            // When the age become mac, the health value decrease
            decreaseHealthValue(a);


// When the age increases and the value of the animal decreases
            
            
        } else {
            Age++;
            price--;

        }
    }

    public void increaseHealthValue(int p) {

        healthValue = ((healthValue + healthValue) * p / 100) + 10;
    }


    public void decreaseHealthValue(int p) {
        if (healthValue != 0)
            healthValue = (int) (healthValue - healthValue * p / 100);
        else
            price = (int) (price - price * p / 100);
    }

    public int getHealth() {
        if (health > 100)
            health = 100;
        return health;
    }

    public String getGender() {
        return gender;
    }


    public int getAge() {
        return Age;
    }

    public double getPrice() {
        return price;
    }

    public boolean isLive() {
        if (health != 0)
            return true;
        else
            System.err.println("The animal is dead -_- ");
        return false;

    }

    public boolean isSick() {
        return sick;
    }

    public boolean setSick() {

        if (!sick) {
            int breed = (int) (Math.random() * 6);
            if (breed  == 0 ) {
                if (health < 100)
                    System.err.println(getAnimalName() + "  " + "is sick");
            decreaseHealth(10);
                    return sick = true;

            } else
                return sick = false;
        } else
            System.err.println(getAnimalName() + "  " + "is still sick");
            return true;

    }

    public boolean Hungry() {
        if (!setSick() && health <30) {
            System.err.println(animalName + " is hungry");
            return true;
        }
        else

            return false;
        }


}









