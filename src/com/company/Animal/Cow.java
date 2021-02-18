package com.company.Animal;

import com.company.Food.Food;
import com.company.Food.Grass;


public class Cow extends Animal {
    public Cow(String animalName, String gender) {
        super(animalName, gender);
        this.price = 35;
        this.Type = "Cow";
        super.Max_age = 12;
        super.Max_breed = 5;
        possibleBreed = 1;

    }

    @Override
    public boolean ICanEat(Food food) {

        if (!isLive()) {
            System.out.println("I cannot eat, I am dei");
        }
        if (food instanceof Grass) {
            if (food.Kg >= 3) {
                System.out.println("I am eating....");
                this.health +=10;
                return true;
            }else System.err.println("It is not enough food, I need at least 3 kilograms ");
        }else
            System.out.println("this food is not appropriate.....");
        return false;
    }


}