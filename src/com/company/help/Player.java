package com.company.help;

import com.company.Animal.*;
import com.company.Food.Food;
import java.util.ArrayList;
import static com.company.help.Dialogs.clear;


public class Player {
    private String name;
    private double money ;
    protected ArrayList<Animal> animals;
    protected  ArrayList<Food> foods;

    protected Player(String name) {
        this.name = name;
        money = 1000;
        animals = new ArrayList<>();
        foods= new ArrayList<>();
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
    public void addFood(Food food){
        if (foods.contains(food))
            return;
        foods.add(food);
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
        System.out.println("-".repeat(50));
        System.out.println(getName() + "'s list"+"\t\t\t\t\t\t"+getMoney() +"\n{Animals}\t\t\t\t{Gender}\t\t\t|" +
                "{Type}\t\t\t{Health}\t\t\t{Age}");
        System.out.println("-".repeat(50));
        for (var listOfAnimals : animals) {
            System.out.println(counter + ". " + listOfAnimals.getAnimalName() +
                    " \t\t\t\t " + listOfAnimals.getGender()+
                    " \t\t\t\t " + listOfAnimals.getType() + "\t\t\t\t " + listOfAnimals.getHealth()+
                    " \t\t\t\t " + listOfAnimals.getCurrentAge()+ " \t\t\t\t " + listOfAnimals.getPrice());
            counter++;
        }
     }
    }
    public void printPlayersStoreFoods() {
        var counter = 1;
        if (this.foods.isEmpty()) {
            System.out.println("You have no Food yet...");
        } else {
            System.out.println("-".repeat(50));
            System.out.println(getName() + "'s list\n{Foods}\t\t\t\t\t{Price}\t\t\t\t{Kg}");
            System.out.println("-".repeat(50));
            for (var listOfFoods : foods) {

                System.out.println(counter + ". " + listOfFoods.getNamesFood() + "\t\t\t\t" + listOfFoods.getPrice()
                        + "\t\t\t\t" + listOfFoods.getKg());
                counter++;
            }
            System.out.println("-".repeat(50));
        }

    }

}
