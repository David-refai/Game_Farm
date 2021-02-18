package com.company.help;



public class Dialogs {



    static public void clear(){
        // "clear" the console by printing 60 new lines
        System.out.println("\n".repeat(2));
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