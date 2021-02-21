package com.company.help;

import java.io.*; // serialization/deserialization

// A helper class to serialize and deserialize data structure
// (objects, array list of objects etc)
public class Serializer {
    private static Game game;
    public Serializer() {
        game = new Game();

    }

    static public boolean saveGame(String filePath) {
        try {
            var file = new FileOutputStream(filePath);
            var out = new ObjectOutputStream(file);
            out.writeObject(new Game().playerTurn());
            out.close();
            file.close();
            System.out.println("Success's save");
            return true; // everything went fine
        }
        catch(Exception error){
            return false; // we couldn't complete the serialization
        }
    }

    static public Object loadGame(String filePath){
        try {
            var file = new FileInputStream(filePath);
            var in = new ObjectInputStream(file);
            game = (Game) in.readObject();
            in.close();
            file.close();
            System.out.println("loading Game");
            return game.playerTurn();
        }
        catch(Exception error){
            return false; // we couldn't complete deserialization
        }
    }

}