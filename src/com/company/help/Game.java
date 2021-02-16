package com.company.help;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public ArrayList<Player> players = new ArrayList<>() ;
    private final Scanner input = new Scanner(System.in);
    private  int rounds;


    public Game() {
        System.out.println("How many round would you like");
        rounds = input.nextInt();
        playerName();
        playerTurn();
    }


    public void playerTurn() {

        for (int i = 1; i <= rounds; i++) {
            for ( Player currentPlayer : players) {
                System.out.println("-".repeat(50));
                System.out.println("Round: "+i+" of " +rounds+"\tPlayer: "+currentPlayer.getName()+ "\tYour Money is "+currentPlayer.getMoney());
                firstMenu(currentPlayer);
                Store.downHealth(currentPlayer);
            }
        }
    }

    public void firstMenu(Player player){
        Dialogs.mainMenu("Buy item", "sell Animal","Feed Animal", "breed animals" ,"My info", "Save, ");
        switch (input.next()){
            case"1"->secondMenu(player);
            case"2"->Store.sellAnimal(player,this);
            case"3"-> Store.feedAnimal(player,this);
            case"4"-> Store.breedAnimal(player,this);
            case "5"-> {
                player.printPlayersStoreFoods();
                player.printPlayersStoreAnimals();
                System.out.println(player.getName());
            }
            default -> System.out.println("It is not matching");
        }
    }
    public void secondMenu(Player player) {
        Dialogs.menuForAnimals( Store.getMaxRound(),"Animals", "Foods", "Back");
        switch (input.next()) {
            case "1" -> Store.buyAnimal(player);
            case "2" -> Store.buyFoods(player);
            case "3" -> firstMenu(player);
        }
    }

public void playerName() {
    System.out.println("How many players 1 - 4 ");
    int  players_count = 0;
    while(true) {
        try {
            players_count = input.nextInt();
            if(players_count >4 || players_count<0)
                throw new Exception();
            break;
        } catch (Exception e) {
            System.out.println("insert number please !");
        }
    }
    for (int i = 0; i <players_count; i++) {
        System.out.println("Player name " + (i + 1));

        players.add((new Player(input.next())));
    }
    printPlayersName();

}

public void printPlayersName() {
    for (var names : players) {
        System.out.println(names.getName() + "    " + names.getMoney());
    }

}

}

