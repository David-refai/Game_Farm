package com.company.Animal;

import com.company.Food.Carrot;
import com.company.Food.Food;

import java.io.Serializable;
import java.util.Random;


public class Rabbit extends Animal implements Serializable {
    public Rabbit(String animalName, String gender) {
        super(animalName, gender);
        this.price = 85;
        this.Type = "Rabbit";
        super.Max_age = 8;
        super.max_breed = 3;
        super.possibleBreed = 4;
        this.veterinarian = 300;
    }




    @Override
    public boolean ICanEat( Food food, int kilogram) {
        Random r = new Random();
        if (food instanceof Carrot) {
            if (kilogram >= 2) {
                float foodModifier = food.getKg() / 3f;
                System.out.println("I am eating....");
                int increase = (int) (r.nextInt(21)+10* foodModifier);
                health += increase;
                if (getHealth() > 100){
                    health= 100;
                }
                return true;
            }else System.err.println("It is not enough food, I need at least 1 kilograms more ");
        }else
            System.out.println("This food is not appropriate.....");
        return false;
    }


}
