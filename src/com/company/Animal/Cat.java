package com.company.Animal;

import com.company.Food.Food;
import com.company.Food.Meat;

import java.io.Serializable;
import java.util.Random;

public class Cat extends Animal implements Serializable {

    public Cat(String animalName, String gender) {
        super(animalName, gender);
        this.price = 100;
        this.Type = "Cat";
        this.Max_age = 5;
        this.max_breed = 4;
        this.possibleBreed = 5;
        this.veterinarian = 350;
    }


    @Override
    public boolean ICanEat(Food food) {
        Random r = new Random();
        if (food instanceof Meat) {
            if (food.getKg() >= 1) {
                float foodModifier = food.getKg();
                System.out.println("Iam eating....");
                int increase = (int) (r.nextInt(21) + 10 * foodModifier);
                setHealth(increase);
                if (getHealth() > 100) {
                    health = 100;
                    return true;
                }

                } else System.err.println("It is not enough food, I need at least 1 kilograms ");
            } else
                System.out.println("this food is not appropriate.....");
            return false;
        }



}
