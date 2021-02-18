package com.company.help;

import com.company.Animal.*;
import com.company.Food.Carrot;
import com.company.Food.Food;
import com.company.Food.Grass;
import com.company.Food.Meat;

import java.io.Serializable;
import java.util.ArrayList;
import static com.company.help.Dialogs.clear;


public class Player implements Serializable {
    protected String name;
    private double money ;
    protected ArrayList<Animal> animals;
    protected  ArrayList<Food> foods;

    public Player(String name) {
        this.name = name;
        this.money = 1000;
        animals = new ArrayList<>();
        foods= new ArrayList<>();

        this.foods.add(new Carrot("Carrot", 15));
        this.foods.add(new Meat("Meat\t", 25));
        this.foods.add(new Grass("Grass", 10));
    }


    public String getName()
    {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double money){
        this.money += money;
    }
    public void decreaseMoney(double money) {
        this.money -= money;
    }

    public void addAnimal(Animal animal){
            animals.add(animal);
    }
    public void printPlayersStoreAnimals() {
        // print the menu of order
        clear();
        if (this.animals.isEmpty())
            System.out.println("You have no Animals yet...");
        else{
            var counter = 1;
        System.out.println("-".repeat(110));
        System.out.println(getName() + "'s list"+"\t\t\t\t\t\t"+getMoney() +"\n{Animals}\t\t\t{Gender}\t\t\t{Type}\t\t\t{Health}\t\t\t{Age}\t\t\t{Current price}");
        System.out.println("-".repeat(110));
        for (var listOfAnimals : animals) {
            System.out.println(counter + ". "+listOfAnimals.getAnimalName()+"\t\t\t "+listOfAnimals.getGender()+ "\t\t\t\t"+listOfAnimals.getType()+"\t\t\t\t"+ listOfAnimals.getHealth()+"\t\t\t\t\t"+listOfAnimals.getAge()+"\t\t\t\t"+ listOfAnimals.getPrice());
            counter++;
        }
     }
    }
    public void printPlayersStoreFoods() {

        var counter = 1;

            System.out.println("-".repeat(50));
            System.out.println(getName() + "'s list\n{Foods}\t\t\t\t\t\t\t\t{Kg}");
            System.out.println("-".repeat(50));
            for (var listOfFoods : foods) {
                boolean t = false;
                for (Food food : foods){
                    if (food.Kg !=0){
                        t = true;
                        break;
                    }
                }
                if (!t){
                    System.out.println("You have no Foods yet...");

                }
                System.out.println(counter + ". " + listOfFoods.getNamesFood()
                        + "\t\t\t\t\t\t\t" + listOfFoods.getKg());
                counter++;

            }

        }

    }


