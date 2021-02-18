package com.company.help;

import com.company.Animal.*;
import com.company.Food.Food;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.*;


public class Store implements Serializable {

        private static final Scanner input = new Scanner(System.in);
        protected static int maxRound = 5;

        public static void sellAnimal (Player player, Game game){

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
        public static void breedAnimal (Player player, Game game){

            if (player.animals.isEmpty()) {
                System.err.println("Buy animals if you want to use this option!");
                game.firstMenu(player);
            }
            player.printPlayersStoreAnimals();
            System.out.println("Enter first Animal: ");
            int choose1 = input.nextInt();
            System.out.println("Enter second Animal:");
            int choose2 = input.nextInt();
            int age1 = player.animals.get(choose1 - 1).getAge();
            int age2 = player.animals.get(choose2 - 1).getAge();
            if (age1 < 2 && age2 < 2) {
                System.err.println("Animals cannot mate, they are younger than 2 years");
                return;
            }
            String gender1 = player.animals.get(choose1 - 1).getGender();
            String gender2 = player.animals.get(choose2 - 1).getGender();

            String type1 = player.animals.get(choose1 - 1).getType();
            String type2 = player.animals.get(choose2 - 1).getType();

            if (!gender1.equals(gender2) && type1.equals(type2)) {
                //cannot breed more than max_breed
                if (player.animals.get(choose1-1).getMax_breed() > 0) {

                    int bound = player.animals.get(choose1 - 1).getPossibleBreed();
                    Random r = new Random();
                    int breed = r.nextInt(bound + 1);

                    for (int i = 0; i < breed; i++) {
                        String randGender = animalsGenderRandom();
                        String randName = chooseAnimalName();
                        switch (type1) {
                            case "Lion" ->  player.animals.add( new Lion(randName, randGender));
                            case "Sheep" -> player.animals.add( new Sheep(randName, randGender));
                            case "Cow" -> player.animals.add( new Cow(randName, randGender));
                            case "Rabbit" -> player.animals.add( new Rabbit(randName, randGender));
                            case "Cat" -> player.animals.add( new Cat(randName, randGender));
                        }
                    }
                    if (breed != 0)
                        System.out.println("breed succesfully :)");
                    else
                        System.out.println("good luck next time");

                    player.animals.get(choose1-1).decreaseMaxBreed(1);
                    player.printPlayersStoreAnimals();
                }else {
                    System.out.println("you cannot breed any more");
                }
            }else
                System.err.println("They are not matching ");
        }

        public static String animalsGenderRandom () {
            String[] mat = new String[]{"Female", "Male"};
            return mat[new Random().nextInt(2)];
        }

        public static void feedAnimal (Player player, Game game){

            if (player.animals.isEmpty()) {
                System.err.println("Buy animals if you want to use this option!");
                game.firstMenu(player);
            }
            boolean t = false;
          for (Food food : player.foods){
              if (food.Kg !=0){
                t = true;
                break;
              }
          }
               if (!t){
                   System.err.println("Buy foods if you want to use this option!");
                   game.firstMenu(player);
               }

            player.printPlayersStoreAnimals();
            System.out.println("Enter number  Animal: ");
            String choose1 = input.next();
            player.printPlayersStoreFoods();
            System.out.println("Enter number of food:");
            String choose2 = input.next();
            System.out.println("Enter how many kg of food:");
            String choose3 = input.next();

            if (player.animals.get(parseInt(choose1) - 1).ICanEat(player.foods.get(parseInt(choose2) - 1)))
                player.foods.get(parseInt(choose2) - 1).Kg -= parseInt(choose3);
                player.animals.get(parseInt(choose1) - 1).increaseHealth(10);
                System.out.println(player.animals.get(parseInt(choose1) - 1).getHealth());
//            } else
//                System.out.println("It is not my food !!!");
        }

        public static void downHealth (Player player){


            for (var animal : player.animals) {
                Random r = new Random();
                int percentage = r.nextInt(21)+10;
                animal.decreaseHealth(percentage);
                animal.decreasePrice(percentage);

                if (animal.getHealth() < 30){
                    System.err.println(animal.getAnimalName() + " I will die, feed me please");
                    System.err.println(animal.isSick());
                }
            }

        }

        public static void buyFoods (Player player){
            Dialogs.menuForAnimals(getMaxRound(), "Carrot\t\t\t\t\t\t\t15",
                    "Meat\t\t\t\t\t\t\t\t25", "Grass\t\t\t\t\t\t\t10");
            System.out.println("\nWhat do you want to buy?");
            var choose1 = input.next();

            switch (choose1) {
                case "1" -> quantityOfFoods(player,player.foods.get(0), parseInt(choose1)-1);
                case "2" -> quantityOfFoods(player,player.foods.get(1), parseInt(choose1)-1);
                case "3" -> quantityOfFoods(player,player.foods.get(2),parseInt(choose1)-1);
                default -> System.out.println("It is not matching");
            }
            player.printPlayersStoreFoods();
      }


        public static void quantityOfFoods (Player player, Food food, int index) {
            System.out.println("How many kilo would have?");
            player.foods.get(index).setQuantity(parseInt(input.next()));

            if (player.getMoney() < food.getPrice()) {
                System.out.println("You don't have enough money");
                return;
            }

            if (food.getQuantity() >= 1 && food.getQuantity() <= 12) {
                player.foods.get(index).setKg(food.getQuantity());
                    player.decreaseMoney(food.getPrice());
                }
            }



        public static int getMaxRound () {
            return maxRound;
        }

        // It is a list of animals that the user can buy from.
        public static void buyAnimal (Player player){


                Dialogs.menuForAnimals(getMaxRound(), "Lion\t\t\t\t\t\t\t35", "Cow\t\t\t\t\t\t\t35",
                        "Cat\t\t\t\t\t\t\t100", "Rabbit\t\t\t\t\t\t85", "Sheep\t\t\t\t\t\t25");
                System.out.println("\nWhat do you want to buy?");
                String type = input.next();

                System.out.println("How many do want to buy ");
                int quantity = input.nextInt();

                double[] mat = new double[]{35, 35, 100, 85, 25};
                double price = mat[Integer.parseInt(type) - 1];
                var total_price = quantity * price;

                if (total_price > player.getMoney()) {
                    System.out.println("You haven't enough money");
                } else {
                    for (int i = 0; i < quantity; i++) {
                        player.decreaseMoney(price);
                        String gender = chooseGender();
                        String name = chooseAnimalName();
                        switch (type) {
                            case "1" -> player.addAnimal(new Lion(name, gender));
                            case "2" -> player.addAnimal(new Cow(name, gender));
                            case "3" -> player.addAnimal(new Cat(name, gender));
                            case "4" -> player.addAnimal(new Rabbit(name, gender));
                            case "5" -> player.addAnimal(new Sheep(name, gender));
                        }
                    }
                }
                player.printPlayersStoreAnimals();

        }

        public static String chooseGender () {
            System.out.println("Which gender would you have\n{1} female   {2}male");
            switch (input.next()) {
                case "1":
                    return "Female";
                case "2":
                    return "Male";
                default:
                    System.err.println("It is not matching");
                    return animalsGenderRandom();
            }
        }

        public static String chooseAnimalName () {
            System.out.println("Would like write name press [1] OR Automatic name [2] ");
            if ("1".equals(input.next())) {
                return input.next();
            }
            return genderSelectNames();
        }


        public static String genderSelectNames () {
            return (femaleNames());
        }
        public static String femaleNames () {

            String[] nameFemale = new String[]{
                    "Alice","Olivia", "Astrid", "Maja", "Vera", "Ebba", "Ella", "Wilma", "Alma", "Lilly",
                    "Elsa","Agnes","Freda", "Saga", "Ellie", "Clara", "Signe", "Alva", "Alicia", "Selma",
                    "Ester", "Stella", "Julia", "Ines", "Leah", "Ellen", "Molly","Iris", "Sara",  "Luna"
                    };
            return nameFemale[new Random().nextInt(30)];
        }
    }



