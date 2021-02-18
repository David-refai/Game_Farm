package com.company.Animal;

import com.company.Food.Food;
import com.company.Food.Grass;

public class Cat extends Animal {

    public Cat(String animalName, String gender) {
        super(animalName, gender);
        price = 100;
        Type = "Cat";
        Max_age = 5;
        Max_breed = 4;
        possibleBreed = 5;
    }

    @Override
    public boolean ICanEat(Food food) {

        if (!isLive()) {
            System.out.println("I cannot eat, I am dei");
        }
        if (food instanceof Grass) {
            if (food.Kg >= 1) {
                System.out.println("Iam eating....");
                this.health +=10;
                return true;
            }else System.err.println("It is not enough food, I need at least 1 kilograms ");
        }else
            System.out.println("this food is not appropriate.....");
        return false;
    }






}
