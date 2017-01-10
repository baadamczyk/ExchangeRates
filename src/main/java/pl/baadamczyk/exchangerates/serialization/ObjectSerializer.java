package pl.baadamczyk.exchangerates.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author baadamczyk
 */
public class ObjectSerializer {
    public static void serializeObject(Object object, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName + ".erf");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
        } catch (IOException iOException) {
            System.out.println("OBJECT NOT SERIALIZED!");
        }
    }
    
    public static Object deserializeObject(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
