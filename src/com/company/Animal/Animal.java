package com.company.Animal;

import com.company.Food.Food;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public abstract class Animal {
     protected int health;
    protected String animalName;
    public String gender;
    protected int age;
    protected int Max_age;
    protected int currentAge;
    public double price;
    protected boolean live ;
    protected String Type;
   protected int Max_breed;




     public Animal(String animalName, String gender) {
         health=100;
         currentAge=1;
         live = true;
        this.animalName = animalName;
        this.gender= gender;

     }




     public abstract boolean ICanEat(Food food);

     public int getMax_breed() {
         return Max_breed;
     }

    public boolean setMax_breed(int max_breed) {
         if(Max_breed !=0) {
             Max_breed -= max_breed;
             return true;
         }else
        return false;
    }

    public String getType() {
         return Type;
     }

     public void setAnimalName(String animalName) {

        this.animalName = animalName;
    }

    public String getAnimalName() {
        return this.animalName;
    }

    public int getCurrentAge() {
        return currentAge;
    }
    public void setHealth1(int health) {
         this.health = (int) Math.round(this.health - (health/100d) * this.health);
    }

    public void increaseHealth(int health) {
        if (this.currentAge == Max_age){
            System.out.println("It is max age");
        }
        else  {
            this.health += health;
            if (this.health == 120)
                this.currentAge +=1;
                System.out.println("Congratulation your animal become  "+getCurrentAge()+ " years");
                this.health = 100;
        }
     }
     public int getHealth() {
         return health;
     }

     public String getGender() {
         return gender;
     }

     public void setGender(String gender) {
         this.gender = gender;
     }

     public int getAge() {
        return age;
    }

    public int getMax_age() {
        return Max_age;
    }

    public void setPrice(double price) {
        this.price = (int) Math.round(this.price - (price/100d) * this.price);

    }

    public double getPrice() {
        return price ;
    }

    public boolean isLive() {
        return live;
    }






     }




