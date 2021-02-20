package com.company.help;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



 // serialization/deserialization

    // A helper class to serialize and deserialize data structure
// (objects, array list of objects etc)
    public class Serializer {

        static public boolean serialize(String filePath, Object data) {
            try {
                var file = new FileOutputStream(filePath);
                var out = new ObjectOutputStream(file);
                out.writeObject(data);
                out.close();
                file.close();
                System.out.println("Successfully saved game!");
                return true; // everything went fine

            }

            catch(Exception error){
                return false; // we couldn't complete the serialization
            }
        }

        static public Object deserialize(String filePath){
            try {
                var file = new FileInputStream(filePath);
                var in = new ObjectInputStream(file);
                var data =(Game) in.readObject();
                in.close();
                file.close();
                return data;
            }
            catch(Exception error){System.out.println("we couldn't complete deserialization");
                return false; // we couldn't complete deserialization
            }
        }

    
}
