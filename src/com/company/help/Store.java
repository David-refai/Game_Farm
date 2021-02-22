package com.company.help;

import com.company.Animal.*;
import com.company.Food.Food;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Integer.*;


public class Store implements Serializable {

        private static final Scanner input = new Scanner(System.in);
        private static String gender;



/*
*This method of selling animal to the store that the player possess
*
 */
        public static void sellAnimal (Player player, Game game){
            String choose1;
            if (player.animals.isEmpty()) {
                System.err.println("Buy animals if you want to use this option!");
                game.firstMenu(player);
            } else {
                player.printPlayersStoreAnimals();


                do {
                    System.out.println("Enter number of an animal: ");
                    choose1 = input.next();
                } while (!"1234567890".contains(choose1));
                //Conditions of selling does not allow the sell of an animal with a health below 40.

                    if (player.animals.get(parseInt(choose1) - 1).getHealth() > 40) {
                        player.addMoney(player.animals.get(parseInt(choose1) - 1).getPrice());

                        player.animals.remove(player.animals.get(parseInt(choose1) - 1));
                        System.out.println(" It is sold, Your Money " + player.getMoney());
                    }else System.err.println("it must health over 40%");
            }
        }

//The beginning of the method is that if there is no animal or no food the player will be alerted and returned
        public static void feedAnimal (Player player, Game game){
            String choose1 ,choose2 ,choose3 ;

            if (player.animals.isEmpty()) {
                System.err.println("Buy animals if you want to use this option!");
                game.firstMenu(player);
               return;
            }
            boolean t = false;
          for (Food food : player.foods){
              if (food.getKg() !=0){
                t = true;
                break;
              }
          }
               if (!t){
                   System.err.println("Buy foods if you want to use this option!");
                   game.firstMenu(player);
                   return;
               }


                do {
                    player.printPlayersStoreAnimals();
                    System.out.println("Enter number  Animal: ");
                    choose1 = input.next();
                }while (!"1234567890".contains(choose1) ||parseInt(choose1)!= player.animals.size()-1);
                do {
                    player.printPlayersStoreFoods();
                    System.out.println("Enter number of food:");
                    choose2 = input.next();
                }while (!"1234567890".contains(choose2) || parseInt(choose2)!= player.foods.size()-1);
                do {
                    System.out.println("Enter how many kg of food:");
                    choose3 = input.next();
                }while (!"1234567890".contains(choose3) );


//Invoke of method ICanEat overrides all the classes of animals
//if the food is sufficient for the animal the health value of the animal in kilograms

            if (player.animals.get(parseInt(choose1) - 1).ICanEat(player.foods.get(parseInt(choose2) - 1)))
                player.foods.get(parseInt(choose2) - 1).Kg -= parseInt(choose3);
                player.animals.get(parseInt(choose1) - 1).increaseHealth(10);
                System.out.println(player.animals.get(parseInt(choose1) - 1).getHealth());

        }

// Purchase of food
        public static void buyFoods (Player player){
            Dialogs.menuForAnimals( "Carrot\t\t\t\t\t\t\t15",
                    "Meat\t\t\t\t\t\t\t\t25", "Grass\t\t\t\t\t\t\t10");
            System.out.println("\nWhat do you want to buy?");
            var choose1 = input.next();

            switch (choose1) {
                case "1" -> quantityOfFoods(player,player.foods.get(0), parseInt(choose1)-1);
                case "2" -> quantityOfFoods(player,player.foods.get(1), parseInt(choose1)-1);
                case "3" -> quantityOfFoods(player,player.foods.get(2),parseInt(choose1)-1);
                default -> System.out.println("It is not matching");
            }
            player.printPlayersStoreFoods(); // Purchased foods is added to a list of a player
      }
// The money of the player is controlled with the quantity food the player can purchase
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





        // It is a list of animals that the user can buy from.
        public static void buyAnimal (Player player){


                Dialogs.menuForAnimals( "Lion\t\t\t\t\t\t\t35", "Cow\t\t\t\t\t\t\t35",
                        "Cat\t\t\t\t\t\t\t100", "Rabbit\t\t\t\t\t\t85", "Sheep\t\t\t\t\t\t25");
            String type;
            do {
                System.out.println("\nWhat do you want to buy?");
                type = input.next();
            } while(!"12345".contains(type));


            String quantity;
            do {
                System.out.println("How many do want to buy ");
                quantity = input.next();
            }  while(!"1234567890".contains(quantity));

// Instance calculates the price compatibility of the purchased object with the below
                double[] mat = new double[]{35, 35, 100, 85, 25};
                double price = mat[Integer.parseInt(type) - 1];
                var total_price = parseInt(quantity) * price;

                if (total_price > player.getMoney()) {
                    System.out.println("You haven't enough money");
                } else {
                    for (int i = 0; i < parseInt(quantity); i++) {
                        player.decreaseMoney(price);
                         gender = chooseGender();
                        String name = chooseAnimalName();
                        switch (type) {
                            case "1" -> player.addAnimal(new Lion(name, gender));
                            case "2" -> player.addAnimal(new Cow(name, gender));
                            case "3" -> player.addAnimal(new Cat(name, gender));
                            case "4" -> player.addAnimal(new Rabbit(name, gender));
                            case "5" -> player.addAnimal(new Sheep(name, gender));
                            default -> System.out.println("It is not matching");
                        }
                    }
                }

        }
//This method invokes when a player chooses purchases an animal
// and allows the player to choose between the gender of the animal that the players chooses to purchase above
        public static String chooseGender () {
            System.out.println("Which gender would you have\n{1} female   {2}male");
            switch (input.next()) {
                case "1":
                    return "Female";
                case "2":
                    return "Male";
                default:
                    System.err.println("Invalid");
                    return chooseGender();
            }
        }
        //The same method of choosing a gender gives the player two options of naming the animal
    // One name is chosen by players choice and the second name is generated automatically
        public static String chooseAnimalName () {

              System.out.println("Would you like to write a name press [1] OR Automatically generated name [2] ");

             if ("1".equals(input.next())) {
                 return  input.next();
                 // Method of name choosing is generated automatically by the gender type name
          }else if (gender.equals("Female"))
            return Store.femaleNames();
             else
            return Store.maleNames();
    }


        public static String femaleNames () {

            String[] nameFemale = {
                    "Alice","Olivia", "Astrid", "Maja", "Vera", "Ebba", "Ella", "Wilma", "Alma", "Lilly",
                    "Elsa","Agnes","Freda", "Saga", "Ellie", "Clara", "Signe", "Alva", "Alicia", "Selma",
                    "Ester", "Stella", "Julia", "Ines", "Leah", "Ellen", "Molly","Iris", "Sara",  "Luna"
                    };
            return nameFemale[new Random().nextInt(30)];
        }
    public static String maleNames (){
        String[] nameMale = {
                "Lucas", "Liam", "William", "Elias", "Noah", "Hugo", "Oliver", "Oscar", "Adam", "Matteo",
                "Walter", "Alexander", "Leo" , "Nils" , "Alfred", "Ludvig", "Adrian", "Theo" , "Leon" ,
                "Elliot", "Arvid" , "Vincent", "Theodor", "Filip", "Axel", "Harry", "Frans", "Charlie",
                "Gabriel", "Isak", "August", "Loui", "Benjamin", "Sam", "Josef", "Ebbe", "Melvin", "Love",
                "Olle", "Albin", "Henry", "Edvin", "Elton", "Emil", "Malte", "Vidar", "Gustav", "Jack", "Frank"
        };
        return nameMale[new Random().nextInt(48)+1 ];
    }

    }



