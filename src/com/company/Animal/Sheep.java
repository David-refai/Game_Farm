package com.company.Animal;

import com.company.Food.Food;
import com.company.Food.Grass;

public class Sheep extends Animal {
    public Sheep(String animalName, String gender) {
        super(animalName, gender);
        this.price = 85;
        this.Type = "Sheep";
        super.Max_age = 8;
        super.Max_breed = 3;
        super.possibleBreed = 1;
    }

    @Override
    public boolean ICanEat(Food food) {

        if (!isLive()) {
            System.out.println("I cannot eat, I am dei");
        }
        if (food instanceof Grass) {
            if (food.Kg >= 3) {
                System.out.println("Iam eating....");
                this.health +=10;
                return true;
            }else System.err.println("It is not enough food, I need at least 3 kilograms ");
        }else
            System.out.println("this food is not appropriate.....");
        return false;
    }


}