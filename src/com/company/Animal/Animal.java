package com.company.Animal;
import com.company.Food.Food;
import com.company.help.Player;

import java.io.Serializable;


public abstract class Animal implements Serializable {
    protected int possibleBreed; //number of childrens in one breed
     protected int health;
    protected String animalName;
    public String gender;
    protected int Max_age;
    protected int Age;
    public double price;
    protected String Type;
   protected int Max_breed;


    public Animal(String animalName, String gender) {
         health=100;
         Age = 2;
        this.animalName = animalName;
        this.gender= gender;
    }
    public boolean isSick() {
        if (health < 20)
           return true;
        else
            return false;

    }

    public int getPossibleBreed() {
        return possibleBreed ;
    }


     public abstract boolean ICanEat(Food food);

     public int getMax_breed() {
         return Max_breed;
     }

    public void decreaseMaxBreed(int m) {
         if(Max_breed !=0) {
             Max_breed -= m;
         }
    }

    public String getType() {
         return Type;
     }


    public String getAnimalName() {
        return this.animalName;
    }


    public void decreaseHealth(int h) {
         health = (health - health*h/100);
    }

    public void increaseHealth(int health) {
        if (this.Age == Max_age){
            System.out.println("It is max age");
        }
        else  {
            this.health += health;
            if (this.health == 140)
                Age += 1;
                System.out.println("Congratulation your animal become  "+ getAge()+ " years");
                this.health = 100;
        }
     }
     public int getHealth() {
         return health;
     }

     public String getGender() {
         return gender;
     }


    public int getAge() {
        return Age;
    }


    public void decreasePrice(int p) {
        price = (int)(price - price*p/100);
    }

    public double getPrice() {
        return price ;
    }

    public boolean isLive() {
         if (health <= 0 )

            return false;
         else
            return true;
    }






     }




