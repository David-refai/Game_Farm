package com.company.help;

import com.company.Animal.Animal;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.*;
public class  Game implements Serializable {


    public ArrayList<Player> players = new ArrayList<>() ;
    private final Scanner input = new Scanner(System.in);
    protected String rounds;
    double max_money;
    double current_money ;
    private Player currentPlayer;
    private String in = "";




    public Game() {
Dialogs.mainMenu("New Game", "continue", "Exit");
String in = input.next();
switch (in){
    case "1"-> {
        howManyRound();
        playerName();
        playerTurn();
    }
    case "2"->Serializer.deserialize("savedGames/Game.ser");
    case "3"-> playerTurn();
    default -> {
        System.out.println(" It is not matching");
       new Game();
    }

}

    }

public void howManyRound(){
        do {
            System.out.println("How many round would you like");
            rounds = input.next();

          if ( parseInt(rounds) < 5 || parseInt(rounds) > 30 ) {
                System.out.println("Enter number between 5 - 30 please! ");
            }
        }while ( parseInt(rounds) < 5 || parseInt(rounds) > 30 );


}


    public void playerTurn() {
        Player max_player = null ;
        for (int i = 1; i <=parseInt(rounds); i++) {
            for ( Player player : players) {
                currentPlayer = player;

                System.out.println("-".repeat(50));
                System.out.println("Round:\t\t\t\t\t\t"+i+" of " +rounds+"\nPlayer:\t\t\t\t\t\t"+currentPlayer.getName()+
                        "\nMoney is:\t\t\t\t\t"+currentPlayer.getMoney()+"\nAnimals:\t\t\t\t\t"+player.animals.size());

                currentPlayer.downHealth();
                var counter = 1;
                System.out.println("-".repeat(50));
                System.out.println("{Animals}\t\t{Gender}\t\t{Type}\t\t{Health}");
                System.out.println("-".repeat(50));
                for (var listOfAnimals : player.animals) {
                System.out.println(counter + ".\t" + listOfAnimals.getAnimalName() + "\t\t" + listOfAnimals.getGender() + "\t\t\t" + listOfAnimals.getType() + "\t\t" + listOfAnimals.getHealth() + "%");
                counter++;
                 }
            }
            firstMenu(currentPlayer);
        }
        //the end

        for ( Player player : players) {
             current_money = player.getMoney();

            for (Animal animal : player.animals) {
                current_money += animal.getPrice() + animal.getHealthValue();
            }
                if (current_money > max_money)
                    max_player = player;
        }
        if (max_player !=null)
            System.out.println("\nThe Winner is :\t\t\t\t"+max_player.getName()+"\nMoney = \t\t\t\t"+ current_money);
        else
            System.out.println("no Winner !");

        new Game();


    }

    public void firstMenu(Player player){

        do {
            Dialogs.mainMenu("Buy item", "sell Animal", "Feed Animal", "breed animals", "My info", "Veterinarian", "Save, ");
                     in = input.next();
            switch (in) {
                case "1" -> secondMenu(player);
                case "2" -> Store.sellAnimal(player, this);
                case "3" -> Store.feedAnimal(player, this);
                case "4" -> player.breedAnimal(this);
                case "5" -> {
                    player.printPlayersStoreFoods();
                    System.out.println("-".repeat(50));
                    player.printPlayersStoreAnimals();
                    System.out.println(player.getName());

                }
                case "6" -> player.Veterinarian(this);
                case "7" -> Serializer.serialize("", this);
                default -> System.out.println("It is not matching");
            }
        }while (!"1234567".contains(in));
    }

    public void secondMenu(Player player) {
        do {
        Dialogs.menuForAnimals( "Animals", "Foods", "Back");
            in = input.next();
        switch (in) {
            case "1" -> Store.buyAnimal(player);
            case "2" -> Store.buyFoods(player);
            case "3" -> firstMenu(player);
            default -> System.out.println("It is not matching");
        }
        }while (!"123".contains(in));
    }

        public void playerName() {
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
                printPlayersName();

            }
        }
public void printPlayersName() {
            for (var names : players) {
                System.out.println(names.getName() + "    " + names.getMoney());
            }
        }



    public void writeToFile(ObjectOutputStream out) throws IOException {
        out.writeObject(this);
        out.close();
    }
    public static Game readToFile() throws IOException {
        // needs to be returned later, so initialized outside of    //try/catch
        Game loadedKirby = null;
        try(FileInputStream in = new FileInputStream(".ser");
            ObjectInputStream s = new ObjectInputStream(in)) {
            loadedKirby = (Game) s.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Loaded previous game!");
        return loadedKirby;
    }





}

