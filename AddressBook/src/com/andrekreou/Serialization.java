package com.andrekreou;

import java.io.*;
import java.util.ArrayList;

public class Serialization {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> personnel2 = customDeserializeList("sList.ser");
        for (ArrayList<String> s : personnel2){
            System.out.println("\nΟνοματεπώνυμο: "+s.get(0));
            System.out.println("Αριθμός Τηλεφώνου: "+s.get(1));
            System.out.println("Διεύθυνση Κατοικίας: "+s.get(2));
            System.out.println("Διεύθυνση E-mail: "+s.get(3));
            System.out.println("Ημερομηνία Γέννησης: "+s.get(4));
            System.out.println("Αριθμός ΑΜΚΑ: "+s.get(5));
        }
    }
    static void customSerializeList(ArrayList<ArrayList<String>> s, String fileName){
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(s);
            objectOut.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static ArrayList<ArrayList<String>> customDeserializeList(String fileName){
        ArrayList<ArrayList<String>> personnel = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            personnel = (ArrayList<ArrayList<String>>) objectIn.readObject(); //Casting. Here cast object to student
            objectIn.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personnel;
    }
}
