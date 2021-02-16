package com.company.Animal;

import com.company.Food.Food;
import com.company.Food.Grass;


import java.util.ArrayList;

public class Sheep extends Animal {
    public Sheep(String animalName, String gender) {
        super(animalName, gender);
        this.price = 85;
        this.Type = "Rabbit";
        super.Max_age = 8;
        super.Max_breed = 3;
    }




    @Override
    public boolean ICanEat(Food food) {
        if (!isLive()) {
            System.out.println("I cant eat, I an dei");
        }
        if (food instanceof Grass) {

            System.out.println("Iam eating....");
            this.health +=10;
            return true;

        }else
            System.out.println("I cannot eat this try again....");

        return false;
    }


}