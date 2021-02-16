package com.company.help;

import com.company.Animal.*;
import com.company.Food.Carrot;
import com.company.Food.Food;
import com.company.Food.Grass;
import com.company.Food.Meat;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.*;


public class Store {
    private static  Scanner input = new Scanner(System.in) ;
    protected static int maxRound = 5;

    public static void sellAnimal(Player player,Game game) {

        if (player.animals.isEmpty()) {
            System.err.println("Buy animals if you want to use this option!");
            game.firstMenu(player);
        } else {
            player.printPlayersStoreAnimals();
            System.out.println("Enter number of an animal: ");
            var choose1 = input.next();
            player.addMoney(player.animals.get(parseInt(choose1) - 1).getPrice());
            player.animals.remove(player.animals.get(parseInt(choose1) - 1));
            System.out.println(" It is sold, Your Money " + player.getMoney());
        }
    }
    public static void breedAnimal(Player player,Game game) {
       Random rand = new Random();
        if (player.animals.isEmpty()) {
            System.err.println("Buy animals if you want to use this option!");
            game.firstMenu(player);
        }
        player.printPlayersStoreAnimals();
        System.out.println("Enter first Animal: ");
        int choose1 = input.nextInt();
        System.out.println("Enter second Animal:");
         int choose2 = input.nextInt();

         String gender1 =  player.animals.get(choose1 - 1).getGender();
         String gender2 =  player.animals.get(choose2 - 1).getGender();

         String type1 =  player.animals.get(choose1 - 1).getType();
         String type2 =  player.animals.get(choose2 - 1).getType();

        if (! gender1.equals(gender2) && type1.equals(type2)) {
            int r = rand.nextInt(2);
            if (r == 0) {
             String randGender = animalsGenderRandom();
             String randName = writeAnimalsNewName();
             switch (type1){
                 case "Lion" : animalRandom(player, new Lion(randName, randGender),choose1 - 1);
                 case "Sheep" : animalRandom(player, new Sheep(randName, randGender),choose1 - 1);
                 case "Cow" : animalRandom(player, new Cow(randName, randGender),choose1 - 1);
                 case "Rabbit" : animalRandom(player, new Rabbit(randName, randGender),choose1 - 1);
                 case "Cat" : animalRandom(player, new Cat(randName, randGender),choose1 - 1);
                }
             System.out.println("you had one more in your list ");
             System.out.println("it is new list ");
             player.printPlayersStoreAnimals();
         }else
             System.out.println("Sorry, try again");
        } else {
            System.err.println("They are not matching ");
        }
    }

    public static void animalRandom(Player player, Animal animal, int index) {
        if (player.animals.get(index).getMax_breed() != 0){
            player.animals.get(index).setMax_breed(1);
            player.animals.add(animal);
        } else
            System.out.println(" It is max");

    }
    public static String animalsGenderRandom(){
        String[] mat = new String[]{"Female", "Male"};
        return mat[new Random().nextInt(2)];
    }

    public static void feedAnimal(Player player,Game game) {

        if (player.animals.isEmpty()) {
            System.err.println("Buy animals if you want to use this option!");
            game.firstMenu(player);
        }if (player.foods.isEmpty()) {
            System.err.println("Buy foods if you want to use this option!");
            game.firstMenu(player);
        }
        player.printPlayersStoreAnimals();
        System.out.println("Enter number  Animal: ");
        String choose1 = input.next();
        player.printPlayersStoreFoods();
        System.out.println("Enter number of food:");
        String choose2 = input.next();

        if (player.animals.get(parseInt(choose1) - 1).ICanEat(player.foods.get(parseInt(choose2) - 1))) {
            player.foods.get(parseInt(choose2) - 1).Kg -=1;
            if (player.foods.get(parseInt(choose2) - 1).getKg() == 0) {
                player.foods.remove(parseInt(choose2) - 1);
            }
            player.animals.get(parseInt(choose1) - 1).increaseHealth(10);
            System.out.println(player.animals.get(parseInt(choose1) - 1).getHealth());
        } else
            System.out.println("It is not my food !!!");
    }

    public static void downHealth(Player player) {

        for (var healthAnimal : player.animals) {
            healthAnimal.setHealth1(10);
            healthAnimal.setPrice(4);
        }

    }

    public static void buyFoods(Player player) {
        Dialogs.menuForAnimals(getMaxRound(), "Carrot\t\t\t\t\t\t\t15",
                "Meat\t\t\t\t\t\t\t25", "Grass\t\t\t\t\t\t\t10");
        System.out.println("\nWhat do you want to buy?");
        var choose1 = input.next();

        switch (choose1) {
            case "1" -> quantityOfFoods(player, new Carrot("Carrot", 15));
            case "2" -> quantityOfFoods(player, new Meat("Meat", 25));
            case "3" -> quantityOfFoods(player, new Grass("Grass", 10));
            default -> System.out.println("It is not matching");
        }
        player.printPlayersStoreFoods();
    }


    public static void quantityOfFoods(Player player, Food food) {
        System.out.println("How many kilo would have?");
        food.setQuantity(parseInt(input.next()));

        if (player.getMoney() < food.getPrice()) {
            System.out.println("You don't have enough money");
            return;
        }

        if (food.getQuantity() >= 1 && food.getQuantity() <= 12)
            food.setKg(food.getQuantity());
        player.decreaseMoney(food.getPrice());
        player.addFood(player, food);
    }


    public static int getMaxRound() {
        return maxRound;
    }

    // It is a list of animals that the user can buy from.
    public static void buyAnimal(Player player) {
        String yesOrNo;
        do {
            Dialogs.menuForAnimals(getMaxRound(), "Lion\t\t\t\t\t\t\t35", "Cow\t\t\t\t\t\t\t35",
                    "Cat\t\t\t\t\t\t\t100", "Rabbit\t\t\t\t\t\t85", "Sheep\t\t\t\t\t\t25");
            System.out.println("\nWhat do you want to buy?");
            String type = input.next();

            System.out.println("How many do want to buy ");
            int quantity = input.nextInt();

            double mat [] = new double []{35,35,100,85,25};
            double price = mat[Integer.parseInt(type)-1];
            var total_price = quantity * price;

            if (total_price > player.getMoney()) {
                System.out.println("You haven't enough money");
            } else {
                for (int i = 0; i < quantity; i++) {
                    player.decreaseMoney(price);
                    String gender = chooseGender();
                    String name = chooseAnimalName();
                    switch (type){
                        case "1" :   player.addAnimal(new Lion(name,gender));
                        case "2" :   player.addAnimal(new Cow(name,gender));
                        case "3" :   player.addAnimal(new Cat(name,gender));
                        case "4" :   player.addAnimal(new Rabbit(name,gender));
                        case "5" :   player.addAnimal(new Sheep(name,gender));
                    }
                }
            }
            player.printPlayersStoreAnimals();
            System.out.println("Do you want to buy more [y]/[n]");
            yesOrNo = input.next();
            maxRound--;
        }while (!yesOrNo.equalsIgnoreCase("n") || maxRound == 0);
    }

    public static String chooseGender() {
        System.out.println("Which gender would you have\n{1} female   {2}male");
        switch (input.next()) {
            case "1" :return "Female";
            case "2" : return "Male";
            default :
                System.err.println("It is not matching");
                return animalsGenderRandom();
        }
    }
    public static String writeAnimalsNewName() {
        String[] randomFemaleNames = new String[]{
                "Annalise",
                "Audrina",
                "Quinn",
                "Emmalee",
                "Cindy",
                "Jessie",
                "Leilani",
                "Matilda",
                "Gisselle",
                "Delilah",
                "Violet",
                "Serenity",
                "Allison",
                "Jada",
                "Kamari",
                "Summer",
                "Micaela",
                "Isabel",
                "Maia",
                "Sandra",
                "Alexus",
                "Patricia",
                "Kelly",
                "Mira",
                "Keira",
                "Emerson",
                "Katie",
                "Hadassah",
                "Larissa",
                "Chana",
                "Jayden",
                "Jacqueline",
                "Ava",
                "Skylar",
                "Kailey",
                "Itzel",
                "Holly",
                "Lizeth",
                "Kristina",
                "Brielle",
                "Kate",
                "Miracle",
                "Jazlyn",
                "Annika",
                "Evangeline",
                "Kendra",
                "Kaylen",
                "Elle",
                "Deborah",
                "Viviana",
                "Leyla",
                "Dana",
                "Susan",
                "Camille",
                "Mary",
                "Charity",
                "Evie",
                "Gia",
                "Sloane",
                "Shania",
                "Annabel",
                "Hope",
                "Lilly",
                "Ashanti",
                "Alicia",
                "Phoenix",
                "Crystal",
                "Judith",
                "Miranda",
                "Nevaeh",
                "Brenna",
                "Yasmine",
                "Hillary",
                "Dayanara",
                "Kyra",
                "Jaylynn",
                "India",
                "Aaliyah",
                "Magdalena",
                "Erin",
                "Saniya",
                "Imani",
                "Cassie",
                "Hadley",
                "Karissa",
                "Virginia",
                "Sasha",
                "Maggie",
                "Belen",
                "Hazel",
                "Alina",
                "Angelina",
                "Cristina",
                "Sariah",
                "Jenna",
                "Gina",
                "Kimora",
                "Eileen",
                "Kaiya",
                "Daphne"};

        return randomFemaleNames[(int) ((Math.random() * 100) + 1) - 1];


    }

    public static String chooseAnimalName() {
        System.out.println("Would like write name press [1] OR Automatic name [2] ");
        switch (input.next()) {
            case "1" :return input.next();
            default :   return genderSelectNames();
        }
    }
    // method for counter quantity and money

    public static String genderSelectNames() {
        return (femaleNames());

    }
        public static String femaleNames(){

            String[] randomFemaleNames = new String[]{

                    "Annalise",
                    "Audrina",
                    "Quinn",
                    "Emmalee",
                    "Cindy",
                    "Jessie",
                    "Leilani",
                    "Matilda",
                    "Gisselle",
                    "Delilah",
                    "Violet",
                    "Serenity",
                    "Allison",
                    "Jada",
                    "Kamari",
                    "Summer",
                    "Micaela",
                    "Isabel",
                    "Maia",
                    "Sandra",
                    "Alexus",
                    "Patricia",
                    "Kelly",
                    "Mira",
                    "Keira",
                    "Emerson",
                    "Katie",
                    "Hadassah",
                    "Larissa",
                    "Chana",
                    "Jayden",
                    "Jacqueline",
                    "Ava",
                    "Skylar",
                    "Kailey",
                    "Itzel",
                    "Holly",
                    "Lizeth",
                    "Kristina",
                    "Brielle",
                    "Kate",
                    "Miracle",
                    "Jazlyn",
                    "Annika",
                    "Evangeline",
                    "Kendra",
                    "Kaylen",
                    "Elle",
                    "Deborah",
                    "Viviana",
                    "Leyla",
                    "Dana",
                    "Susan",
                    "Camille",
                    "Mary",
                    "Charity",
                    "Evie",
                    "Gia",
                    "Sloane",
                    "Shania",
                    "Annabel",
                    "Hope",
                    "Lilly",
                    "Ashanti",
                    "Alicia",
                    "Phoenix",
                    "Crystal",
                    "Judith",
                    "Miranda",
                    "Nevaeh",
                    "Brenna",
                    "Yasmine",
                    "Hillary",
                    "Dayanara",
                    "Kyra",
                    "Jaylynn",
                    "India",
                    "Aaliyah",
                    "Magdalena",
                    "Erin",
                    "Saniya",
                    "Imani",
                    "Cassie",
                    "Hadley",
                    "Karissa",
                    "Virginia",
                    "Sasha",
                    "Maggie",
                    "Belen",
                    "Hazel",
                    "Alina",
                    "Angelina",
                    "Cristina",
                    "Sariah",
                    "Jenna",
                    "Gina",
                    "Kimora",
                    "Eileen",
                    "Kaiya",
                    "Daphne"};

            return randomFemaleNames[(int) ((Math.random() * 100) + 1) - 1];
        }
    }
