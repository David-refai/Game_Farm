package com.company.Animal;

import com.company.Food.Food;
import com.company.Food.Meat;

import java.util.Random;

public class Lion extends Animal{

    public Lion(String animalName, String gender) {
        super(animalName, gender);
        super.price = 35;
        this.Type = "Lion";
        super.Max_age = 10;
        this.Max_breed = 4;
        this.possibleBreed = 1;
        this.veterinarian = 200;


    }


    @Override
    public boolean ICanEat(Food food ) {
        Random r = new Random();
        if (food instanceof Meat) {
            if (food.getKg() >= 3) {
                float foodModifier = food.getKg() / 3f;
            System.out.println("I am eating....");
            int increase = (int) (r.nextInt(21)+10* foodModifier);
            health += increase;
            if (health > 100){
                health= 100;
                return true;
            }

            }else System.err.println("It is not enough food, I need at least 3 kilograms ");
            return false;
        }else
            System.err.println("this food is not appropriate.....");
        return false;
    }

    }



