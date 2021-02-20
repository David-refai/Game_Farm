package com.company.Animal;

import com.company.Food.Carrot;
import com.company.Food.Food;

import java.util.Random;


public class Rabbit extends Animal{
    public Rabbit(String animalName, String gender) {
        super(animalName, gender);
        this.price = 85;
        this.Type = "Rabbit";
        super.Max_age = 8;
        super.Max_breed = 3;
        super.possibleBreed = 4;
        this.veterinarian = 300;
    }




    @Override
    public boolean ICanEat( Food food) {
        Random r = new Random();
        if (food instanceof Carrot) {
            if (food.getKg() >= 3) {
                float foodModifier = food.getKg() / 3f;
                System.out.println("I am eating....");
                int increase = (int) (r.nextInt(21)+10* foodModifier);
                health += increase;
                if (health > 100){
                    health= 100;
                    return true;
                }
            }else System.err.println("It is not enough food, I need at least 1 kilograms ");
        }else
            System.out.println("this food is not appropriate.....");
        return false;
    }


}
