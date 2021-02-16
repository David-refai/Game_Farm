package com.company.Animal;

import com.company.Food.Food;
import com.company.Food.Meat;

import java.util.ArrayList;

public class Lion extends Animal{

    public Lion(String animalName, String gender) {
        super(animalName, gender);
        super.price = 35;
        this.Type = "Lion";
        super.Max_age = 10;
        this.Max_breed = 2;


    }


    @Override
    public boolean ICanEat(Food food ) {

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



