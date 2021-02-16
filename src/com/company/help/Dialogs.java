package com.company.help;

import java.util.*;

public class Dialogs {

    static private Scanner scanner = new Scanner(System.in);

    static public void clear(){
        // "clear" the console by printing 60 new lines
        System.out.println("\n".repeat(2));
    }

    static public String prompt(String question){
        // clear() ? maybe we want a clear before each prompt
        System.out.println(question);
        return scanner.nextLine();
    }

    static public int promptInt(String question, int min, int max){
        var num = min - 1;
        try {
            num = Integer.parseInt(prompt(question));
        }
        catch(Exception ignore){}
        // if illegal choice show the prompt again (recursion)
        // otherwise return the choice
        return num < min || num > max ?
                promptInt(question, min, max) : num;
    }

    public static void menuForAnimals(int title, String ...options){
        // print the menu

        clear();
       System.out.println("-".repeat(50));
        System.out.println(title);
        System.out.println("-".repeat(50));
        var counter = 1;
        for(var option : options){
            System.out.println(counter + ". " + option);
            counter++;
        }
        System.out.println("-".repeat(50));


    }
    public static void menuForFoods(String ...options){
        // print the menu
        clear();
        System.out.println("-".repeat(50));
        System.out.println("Foods\t\t\t\t\t\t\tPrice ");
        System.out.println("-".repeat(50));
        var counter = 1;
        for(var option : options){
            System.out.println(counter + ". " + option);
            counter++;
        }
        System.out.println("-".repeat(50));
    }
    public static void mainMenu(String ...options){

        System.out.println("-".repeat(50));
        var counter = 1;
        for(var option : options){
            System.out.println(counter + ". " + option);
            counter++;
        }
        System.out.println("-".repeat(50));


    }

}