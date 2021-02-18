package com.company.Animal;

import com.company.Food.Food;
import com.company.Food.Meat;

public class Lion extends Animal{

    public Lion(String animalName, String gender) {
        super(animalName, gender);
        super.price = 35;
        this.Type = "Lion";
        super.Max_age = 10;
        this.Max_breed = 4;
        possibleBreed = 1;


    }


    @Override
    public boolean ICanEat(Food food ) {

        if (!isLive()) {
            System.out.println("I cannot eat, I am dei");
        }
        if (food instanceof Meat) {
            if (food.Kg >= 3) {
            System.out.println("I am eating....");
            this.health +=10;
            return true;
            }else System.err.println("It is not enough food, I need at least 3 kilograms ");
            return false;
        }else
            System.err.println("this food is not appropriate.....");
        return false;
    }

    }



