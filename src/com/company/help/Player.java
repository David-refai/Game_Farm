package com.company.help;

import com.company.Animal.*;
import com.company.Food.Carrot;
import com.company.Food.Food;
import com.company.Food.Grass;
import com.company.Food.Meat;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static com.company.help.Dialogs.clear;

import static com.company.help.Store.chooseAnimalName;



public class Player implements Serializable {
    protected String name;
    private double money ;
    protected ArrayList<Animal> animals;
    protected  ArrayList<Food> foods;
    protected Scanner input;
    protected String[] mat;
    protected String randGender;
    public Player(String name) {
        this.name = name;
        this.money = 1000;
        animals = new ArrayList<>();
        foods= new ArrayList<>();
        input = new Scanner(System.in);


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
        else {
            var counter = 1;
            System.out.println("-".repeat(110));
            System.out.println(getName() + "'s list" + "\t\t\t\t\t\t" + getMoney() + "\n{Animals}\t\t\t{Gender}\t\t\t{Type}\t\t\t{Health}\t\t\t{Age}\t\t\t{Current price}");
            System.out.println("-".repeat(110));
            for (var listOfAnimals : animals) {
                System.out.println(counter + ". " + listOfAnimals.getAnimalName() + "\t\t\t " + listOfAnimals.getGender() + "\t\t\t\t" + listOfAnimals.getType() + "\t\t\t\t" + listOfAnimals.getHealth() + "%" + "\t\t\t\t\t"
                        + listOfAnimals.getAge() + "\t\t\t\t" + listOfAnimals.getPrice() + "\t\t\t\t" + listOfAnimals.getHealthValue());
                counter++;
            }
        }
    }
    public void breedAnimal ( Game game){
        int choose1, choose2;
        if (animals.isEmpty()) {
            System.err.println("Buy animals if you want to use this option!");
            game.firstMenu(this);
        }
       printPlayersStoreAnimals();

        System.out.println("Enter first animal");
        choose1 = input.nextInt();
        System.out.println("Enter second animal");
        choose2 = input.nextInt();
        String gender1 = animals.get(choose1 - 1).getGender();
        String gender2 = animals.get(choose2 - 1).getGender();

        String type1 = animals.get(choose1 - 1).getType();
        String type2 = animals.get(choose2 - 1).getType();
        if (!gender1.equals(gender2) && type1.equals(type2)) {
        if (animals.get(choose1-1).getMax_breed()> 0 && animals.get(choose1-1).getMax_breed() > 0) {

        int bound = animals.get(choose1 - 1).getPossibleBreed();
        Random r = new Random();
        int breed = r.nextInt(bound + 1);

                    for (int i = 0; i < breed; i++) {
                     randGender = animalsGenderRandom();
                    String randName = chooseAnimalName();
                    switch (type1) {
                        case "Lion" ->  animals.add( new Lion(randName, randGender));
                        case "Sheep" -> animals.add( new Sheep(randName, randGender));
                        case "Cow" -> animals.add( new Cow(randName, randGender));
                        case "Rabbit" -> animals.add( new Rabbit(randName, randGender));
                        case "Cat" -> animals.add( new Cat(randName, randGender));
                        default -> System.err.println(" It is fel option");
                    }
                }if (breed != 0)
            System.out.println("breed successfully :)");
        else
            System.out.println("good luck next time");
            animals.get(choose1 - 1).decreaseMaxBreed(1);
            animals.get(choose2 - 1).decreaseMaxBreed(1);
            printPlayersStoreAnimals();
        }
        else
            {
            System.out.println("you cannot breed any more");
        }
        }
        else
            System.err.println("They are not matching ");

    }
    public  String animalsGenderRandom () {
         mat = new String[]{"Female", "Male"};
        return mat[new Random().nextInt(2)];
    }
    public  String chooseAnimalName () {
        String in1;
        var maleChoice = false;
        System.out.println("Would like write name press [1] OR Automatic name [2] ");
        in1 = input.next();
        if ("1".equals(in1)) {
            return in1 = input.next();
        }else
        if (randGender.equals("Female"))
            return Store.femaleNames();
            else
                return Store.maleNames();
    }
    public void Veterinarian(Game game) {
        Random r = new Random();
        int choose1 = 0;
        if (animals.isEmpty()) {
            System.err.println("Buy animals if you want to use this option!");
            game.firstMenu(this);
        }
        printPlayersStoreAnimals();


        System.out.println("Enter number of  animal");
        choose1 = input.nextInt();

        if (getMoney() < animals.get(choose1-1).getVeterinarian())
            System.out.println("You don't have money enough..");
        if (!animals.get(choose1 - 1).isSick()) {
            System.out.println("This animal is not sick and does not need to be treated ");
            decreaseMoney(animals.get(choose1 -1).getVeterinarian());
        } else  {

            int breed = r.nextInt(2);
            if (breed != 0){
                decreaseMoney(animals.get(choose1 -1).getVeterinarian());

                float foodModifier = animals.get(choose1 - 1).health * 3/5f;
                int increase = (int) (r.nextInt(21) + 10 * foodModifier);
                animals.get(choose1 - 1).increaseHealth(increase);
                animals.get(choose1 -1).isTreatment();

                    if (animals.get(choose1 - 1).getHealth() > 100)
                        animals.get(choose1 - 1).health = 100;
                        System.out.println("The treatment has been done. ");



        } else {
                animals.get(choose1 - 1).health = 0;
                System.err.println("Unfortunately, I couldn't help him");
                animals.remove(animals.get(choose1 - 1));
            }
        }
    }


    public void downHealth () {

        try {
            for (Animal animal : animals ) {
                Random r = new Random();
                int percentage = r.nextInt(21) + 10;
                animal.increaseAge(percentage);
                animal.decreaseHealth(percentage);

                animal.Hungry();

               // animal.isSick();
              // if (animal.isSick()!=animal.Hungry())


//                if (!animal.isSick() && animal.getHealth() <= 30 ) {
//                    System.err.println(animal.getAnimalName() + " is hungry ");

//                }//else animal.isSick();
                if (!animal.isLive()) {
                    animals.remove(animal);
                }
            }

        } catch (Exception e) {
            System.err.println("Your animal is dead");
        }
    }
    public void printPlayersStoreFoods() {
        boolean t = false;
        var counter = 1;

            System.out.println("-".repeat(50));
            System.out.println(getName() + "'s list\n{Foods}\t\t\t\t\t\t\t\t{Kg}");
            System.out.println("-".repeat(50));
            for (var listOfFoods : foods) {

                for (Food food : foods){
                    if (food.Kg !=0){
                        t = true;
                        break;
                    }
                }

                System.out.println(counter + ". " + listOfFoods.getNamesFood()
                        + "\t\t\t\t\t\t\t" + listOfFoods.getKg());
                counter++;

            }
        if (!t){
            System.out.println("You have no Foods yet...");

        }
        }
    private void readObject(ObjectInputStream i){

    }
    private void writeObject(ObjectInputStream o){

    }

    }


