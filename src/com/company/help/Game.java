package com.company.help;
import com.company.Animal.Animal;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.*;


public  class Game implements Serializable {




        public ArrayList<Player> players = new ArrayList<>();
        private final Scanner input = new Scanner(System.in);
        protected String rounds;
        double max_money;
        double current_money;
        private Player currentPlayer;
        private String in = "";
        protected String information= """
                Choose rounds (5-30) and quantity (1-4) of players.
                Every player is given a sum of money and begins with 0 animals.
                Player can choose between (5) different kinds of animals,the gender and name the animal.
                Food can be purchased for the animal.
                The health value of the animal decreases every round.
                If the animal is fed the right food and the right amount the health value increases.
                The cow must be fed with at least three kilograms of grass.
                The rabbit must be feed with at least twi kilograms of carrots.
                The lion must be fed with at least three kilograms of meat.
                The cat must be fed with at least one kilograms of meat.
                The sheep must be feed with at least two kilograms of grass.
                Food cannot be sold.
                Foods and animals are purchased from the store.
                There is a 20% each round that the animal can get sick.
                """;



        public  Game() {

            Dialogs.mainMenu("New Game", "continue", "Exit");
            String in = input.next();
            switch (in) {
                case "1" -> {
                    howManyRound();
                    playerName();
                    playerTurn();
                }
                case "2" -> Serializer.loadGame("Game.ser");

                case "3" -> System.exit(0);
                default -> {
                    System.out.println(" It is not matching");
                  new Game();
                }

            }

        }
        public void howManyRound () {
            try {
                do {
                    System.out.println("How many round would you like");
                    System.out.println("Enter number between 5 - 30 please! ");
                    rounds = input.next();
                } while (parseInt(rounds) < 5 || parseInt(rounds) > 30);
            }catch (Exception e){
                System.out.println("Enter a number please!");
                howManyRound();
            }

        }
         public void playerName () {
          String players_count;
        do {
            System.out.println("How many players 1 - 4 ");
            players_count = input.next();
        } while (!"1234".contains(players_count));

        if (Integer.parseInt(players_count) <= 4 || Integer.parseInt(players_count) > 0) {
            for (int i = 0; i < Integer.parseInt(players_count); i++) {
                System.out.println("Player name " + (i + 1));
                players.add((new Player(input.next())));
            }

        }
    }


        public boolean playerTurn () {
            Player max_player = null;
            for (int i = 1; i <= parseInt(rounds); i++) {
                for (Player player : players) {
                    currentPlayer = player;
                    System.out.println("\n".repeat(10));
                    System.out.println("-".repeat(50));
                    System.out.println("Rounds:\t\t\t\t\t\t" + i + " of " + rounds + "\nPlayer:\t\t\t\t\t\t" + currentPlayer.getName() +
                            "\nMoney count:\t\t\t\t\t" + currentPlayer.getMoney()+"$" + "\nAnimals:\t\t\t\t\t" + player.animals.size());


                    var count = 1;
                    System.out.println("-".repeat(50));
                    System.out.println("{Animals}\t\t{Gender}\t\t{Type}\t\t{Health}");
                    System.out.println("-".repeat(50));
                    for (var listOfAnimals : player.animals) {

                        System.out.println(count + ". " + listOfAnimals.getAnimalName()+" "+ listOfAnimals.getPrintSick() +"\t\t\t" + listOfAnimals.getGender() + "\t\t" + listOfAnimals.getType() + "\t\t" + listOfAnimals.getHealth() + "%");
                        count++;

                    }
                    System.out.println("-".repeat(50));
                    for (var food: player.foods) {
                        System.out.print(food.getNamesFood() + "\t" + food.getKg()+" kg\t\t");

                    }
                    System.out.println("\n"+"-".repeat(50));
                    currentPlayer.downHealth();
                    firstMenu(currentPlayer);
                }

            }
            //the end
            currentPlayer.printPlayersStoreAnimals();
            for (Player player : players) {
                current_money = player.getMoney();
                for (Animal animal : player.animals) {
                    current_money += animal.getPrice() + animal.getHealthValue(); }
                if (current_money > max_money)
                    max_player = player; }
            if (max_player != null)
                System.out.println("\nThe Winner is :\t\t\t\t" + max_player.getName() + "\nMoney = \t\t\t\t" + current_money);
            else
                   System.out.println("No Winner!");
            return false;
        }

        public void firstMenu (Player player){
            do {
                Dialogs.mainMenu("Buy item", "Sell Animal", "Feed Animal", "Breed animals", "Instructions", "Veterinarian","Save");
                in = input.next();

                switch (in) {
                    case "1" -> secondMenu(player);
                    case "2" -> Store.sellAnimal(player, this);
                    case "3" -> Store.feedAnimal(player, this);
                    case "4" -> player.breedAnimal(this);
                    case "5" -> {
                        System.out.println(information);
                        firstMenu(player);
                    }
                    case "6" -> player.Veterinarian(this);
                    case "7" -> {
                      Serializer.saveGame("Game.ser");
                        System.out.println("Would you like to continue [yes] OR [no]");
                        String string = input.next();
                        if (string.equalsIgnoreCase("yes")) {
                            new Game();
                        } else
                            System.exit(0);
                    }
                    default -> System.out.println("It is not matching");
                }
            } while (!"1234567".contains(in));
        }


        public void secondMenu (Player player){
            do {
                Dialogs.menuForAnimals("Animals", "Foods", "Back");
                in = input.next();
                switch (in) {
                    case "1" -> Store.buyAnimal(player);
                    case "2" -> Store.buyFoods(player);
                    case "3" -> firstMenu(player);
                    default -> System.out.println("It is not matching");
                }
            } while (!"123".contains(in));
        }



}
