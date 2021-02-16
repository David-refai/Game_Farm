package com.company.Animal;

import com.company.Food.Food;
import com.company.Food.Meat;

import java.util.ArrayList;

public class Cat extends Animal {


    public Cat(String animalName, String gender) {
        super(animalName, gender);
        price = 100;
        Type = "Cat";
        Max_age = 5;
        Max_breed = 2;
    }

    @Override
    public boolean ICanEat(Food food) {
        if (!isLive()) {
            System.out.println("I cant eat, I an dei");
        }
        if (food instanceof Meat) {

            System.out.println("Iam eating....");
            this.health +=10;
            return true;

        }else
            System.out.println("I cannot eat this try again....");

        return false;
    }






}
