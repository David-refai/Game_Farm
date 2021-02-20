package com.company.Animal;

import com.company.Food.Food;
import com.company.Food.Grass;

import java.util.Random;


public class Cow extends Animal {
    public Cow(String animalName, String gender) {
        super(animalName, gender);
        this.price = 35;
        this.Type = "Cow";
        super.Max_age = 12;
        super.Max_breed = 5;
        this.possibleBreed = 1;
        this.veterinarian = 200;
    }

    @Override
    public boolean ICanEat(Food food) {
        Random r = new Random();
        if (food instanceof Grass) {
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
        }else
            System.out.println("this food is not appropriate.....");
        return false;
    }


}