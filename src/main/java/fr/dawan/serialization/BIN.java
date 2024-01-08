package fr.dawan.serialization;

import fr.dawan.genericite.Product;

import java.io.*;
import java.util.List;

public class BIN {
    public static void encodeToFile(Object obj, String path) throws FileNotFoundException, IOException {

        try (ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
        }
    }

    public static Object decodeFromFile(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        Object result = null;
        try (ObjectInput ois = new ObjectInputStream(new FileInputStream(path))) {
            result = ois.readObject();
        }
        return result;
    }
}
