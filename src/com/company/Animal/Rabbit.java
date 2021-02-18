package com.company.Animal;

import com.company.Food.Carrot;
import com.company.Food.Food;
import com.company.Food.Grass;

public class Rabbit extends Animal{
    public Rabbit(String animalName, String gender) {
        super(animalName, gender);
        this.price = 85;
        this.Type = "Rabbit";
        super.Max_age = 8;
        super.Max_breed = 3;
        super.possibleBreed = 4;

    }




    @Override
    public boolean ICanEat( Food food) {

        if (!isLive()) {
            System.out.println("I cant eat, I am dei");
        }
        if (food instanceof Carrot) {
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
