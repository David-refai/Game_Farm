package com.company.Animal;

import com.company.Food.Carrot;
import com.company.Food.Food;



import java.util.ArrayList;

public class Rabbit extends Animal{
    public Rabbit(String animalName, String gender) {
        super(animalName, gender);
        this.price = 85;
        this.Type = "Rabbit";
        super.Max_age = 8;
        super.Max_breed = 3;

        this.health = getHealth();
    }




    @Override
    public boolean ICanEat( Food food) {
        if (!isLive()) {
            System.out.println("I cant eat, I an dei");
        }
        if (food instanceof Carrot) {

            System.out.println("Iam eating....");
            this.health +=10;
            return true;

        }else
            System.out.println("I cannot eat this try again....");

        return false;
    }


}
