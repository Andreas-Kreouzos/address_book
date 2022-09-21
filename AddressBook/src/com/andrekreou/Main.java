package com.andrekreou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static com.andrekreou.Serialization.customDeserializeList;
import static com.andrekreou.Serialization.customSerializeList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Καλώς ορίσατε στον κατάλογο επαφών");
        System.out.println("Στο μενού που ακολουθεί, δίνονται όλες οι διαθέσιμες επιλογές καταλόγου φοιτητών");

        //Ορισμός διπλής λίστας για την αποθήκευση των καταχωρήσεων
        ArrayList<ArrayList<String>> catalog = customDeserializeList("sList.ser");
        Personnel p1 = new Personnel();
        Scanner user_input = new Scanner(System.in);

        while (true){
            showMenu(); //Ο κώδικας της μεθόδου αποτυπώνεται προς το τέλος της κλάσης
            String selection = user_input.next();

            if (selection.equals("1")){
                if (catalog.isEmpty()){
                    System.out.println("Το ευρετήριο είναι άδειο!!!\n");
                } else {
                    System.out.println("Παρακάτω μπορείτε να δείτε όλες τις διαθέσιμες επαφές");

                    for (ArrayList<String> strings : catalog) {
                        printList(strings);
                    }
                }

            }else if (selection.equals("2")){
                System.out.println("Παρακαλώ εισάγετε τα στοιχεία της επαφής");

                //Ορισμός μονοδιάστατης λίστας. Σ αυτήν θα αποθηκεύονται οι καταχωρήσεις του χρήστη ως λίστες
                ArrayList<String> catalog_copy = new ArrayList<>();

                System.out.println("Εισάγετε το ονοματεπώνυμο:");
                Scanner scan = new Scanner(System.in);
                String full_name = scan.nextLine();
                p1.setFull_name(full_name);
                catalog_copy.add(full_name);
                System.out.println("Δώσατε το ονοματεπώνυμο: "+p1.getFull_name());

                System.out.println("Εισάγετε τον αριθμό τηλεφώνου:");
                Scanner phone_number_input = new Scanner(System.in);
                String phone_number = phone_number_input.next();
                p1.setPhone_number(phone_number);
                catalog_copy.add(phone_number);
                System.out.println("Δώσατε τον αριθμο τηλεφώνου: "+p1.getPhone_number());

                System.out.println("Εισάγετε την διεύθυνση κατοικίας:");
                Scanner address_input = new Scanner(System.in);
                String address = address_input.nextLine();
                p1.setAddress(address);
                catalog_copy.add(address);
                System.out.println("Δώσατε την διεύθυνση κατοικίας: "+p1.getAddress());

                System.out.println("Εισάγετε την διεύθυνση e-mail:");
                Scanner email_input = new Scanner(System.in);
                String email = email_input.next();
                p1.setEmail(email);
                catalog_copy.add(email);
                System.out.println("Δώσατε την ακόλουθη διεύθυνση e-mail: "+p1.getEmail());

                System.out.println("Εισάγετε την ημερομηνία γέννησης:");
                Scanner date_of_birth_input = new Scanner(System.in);
                String date_of_birth = date_of_birth_input.nextLine();
                p1.setDate_of_birth(date_of_birth);
                catalog_copy.add(date_of_birth);
                System.out.println("Δώσατε την ακόλουθη ημερομηνία: "+p1.getDate_of_birth());

                System.out.println("Εισάγετε τον αριθμό ΑΜΚΑ:");
                Scanner AMKA_input = new Scanner(System.in);
                String AMKA = AMKA_input.next();
                p1.setAMKA(AMKA);
                catalog_copy.add(AMKA);
                System.out.println("Δώσατε τον ακόλουθο ΑΜΚΑ: "+p1.getAMKA());

                //Προσθήκη των καταχωρήσεων μονοδιάστατης λίστας στην διπλή
                catalog.addAll(Collections.singleton(catalog_copy));
                System.out.println("\nΗ επαφή προστέθηκε!!!");
                printList(catalog_copy);

            }else if (selection.equals("3")){
                if (catalog.isEmpty()){
                    System.out.println("Το ευρετήριο είναι άδειο!!!\n");
                    continue;
                }
                System.out.println("Επιλέξτε το όνομα της επαφής προς αναζήτηση");
                Scanner retrieve_input = new Scanner(System.in);
                String retrieve = retrieve_input.nextLine();
                int count_if_true = 0; //Έλεγχος αν αληθεύει η εισόδος του χρήστη
                for (ArrayList<String> list : catalog) {
                    if (list.get(0).contains(retrieve)) { //list -> οι έσω λίστες, με ιδιότητα get στο στοιχείο 0, όπου αποθηκεύεται το όνομα.
                        list.indexOf(retrieve);
                        printList(list); // Εκτύπωση της λίστας που ζητήθηκε. Ο κώδικας της μεθόδου printList βρίσκεται προς το τέλος της κλάσης main.
                        count_if_true += 1; //Αύξηση του μετρητή αν η είσοδος του χρήστη, υπάρχει στο ευρετήριο.
                    }
                }
                if (count_if_true == 0) { //Αλλιώς, ο μετρητής παραμένει μηδέν και τυπώνεται το ανάλογο μήνυμα.
                    System.out.println("Δεν υπάρχει τέτοιο όνομα στο ευρετήριο\n");
                }

            }else if (selection.equals("4")){
                if (catalog.isEmpty()){
                    System.out.println("Το ευρετήριο είναι άδειο!!!\n");
                    continue;
                }
                System.out.println("Επιλέξτε το όνομα της επαφής προς επεξεργασία");
                Scanner modify_input = new Scanner(System.in);
                String modify = modify_input.nextLine();
                for (ArrayList<String> list : catalog) {
                    if (list.get(0).contains(modify)) {
                        System.out.println("Εισάγετε το ονοματεπώνυμο προς αλλαγή:");
                        Scanner modify_name_input = new Scanner(System.in);
                        String change_name = modify_name_input.nextLine();
                        list.set(0, change_name); //Ιδιότητα set στο στοιχείο 0, για να αλλαχθεί το όνομα.

                        System.out.println("Εισάγετε τον αριθμό τηλεφώνου προς αλλαγή:");
                        Scanner modify_phone_input = new Scanner(System.in);
                        String change_phone = modify_phone_input.nextLine();
                        list.set(1, change_phone); //Ιδιότητα set στο στοιχείο 1, για να αλλαχθεί το τηλέφωνο.

                        System.out.println("Εισάγετε την διεύθυνση κατοικίας προς αλλαγή:");
                        Scanner modify_address_input = new Scanner(System.in);
                        String change_address = modify_address_input.nextLine();
                        list.set(2, change_address); //Ιδιότητα set στο στοιχείο 2, για να αλλαχθεί η διεύθυνση κατοικίας.

                        System.out.println("Εισάγετε την διεύθυνση e-mail προς αλλαγή:");
                        Scanner modify_email_input = new Scanner(System.in);
                        String change_email = modify_email_input.nextLine();
                        list.set(3, change_email); //Ιδιότητα set στο στοιχείο 3, για να αλλαχθεί η διεύθυνση mail.

                        System.out.println("Εισάγετε την ημερομηνία γέννησης προς αλλαγή:");
                        Scanner modify_date_input = new Scanner(System.in);
                        String change_date = modify_date_input.nextLine();
                        list.set(4, change_date); //Ιδιότητα set στο στοιχείο 4, για να αλλαχθεί η ημερομηνία γέννησης.

                        System.out.println("Εισάγετε τον αριθμό ΑΜΚΑ προς αλλαγή:");
                        Scanner modify_amka_input = new Scanner(System.in);
                        String change_amka = modify_amka_input.nextLine();
                        list.set(5, change_amka); //Ιδιότητα set στο στοιχείο 5, για να αλλαχθεί ο αριθμός ΑΜΚΑ.

                        System.out.println("\nΗ επαφή μορφοποιήθηκε!!!");
                        printList(list);
                    } else {
                        System.out.println("Δεν υπάρχει τέτοιο όνομα στο ευρετήριο\n");
                    }
                }

            }else if (selection.equals("5")){
                if (catalog.isEmpty()){
                    System.out.println("Το ευρετήριο είναι άδειο!!!\n");
                    continue;
                }
                System.out.println("Επιλέξτε το όνομα της επαφής προς διαγραφή");
                Scanner delete_input = new Scanner(System.in);
                String delete = delete_input.nextLine();
                int count_if_true = 0;
                for (ArrayList<String> list : catalog) {
                    if (list.get(0).contains(delete)){
                        list.clear();
                        count_if_true += 1;
                    }
                }
                if (count_if_true == 0) {
                    System.out.println("Δεν υπάρχει τέτοιο όνομα στο ευρετήριο\n");
                } else{
                    System.out.println("Η επαφή διεγράφει");
                }
                //Κατά την εκτέλεση της λειτουργίας clear, αφήνονται κενές λίστες.
                //Η παρακάτω γραμμή της αφαιρεί για κάθε λίστα που είναι κενή.
                catalog.removeIf(x -> x != null && x.isEmpty());
                System.out.println("Εναπομείναντες επαφές:\n"+catalog);

            }else if (selection.equals("6")){

                customSerializeList(catalog,"sList.ser"); //Αποθήκευση σε αρχείο κατά το κλείσιμο.
                System.out.println("Η εφαρμογή ευρητηρίου τερματίστηκε.");
                return;
            }
        }
    }

    public static void printList(ArrayList<String> strings) {
        System.out.println("\nΟνοματεπώνυμο: "+strings.get(0));
        System.out.println("Αριθμός Τηλεφώνου: "+strings.get(1));
        System.out.println("Διεύθυνση Κατοικίας: "+strings.get(2));
        System.out.println("Διεύθυνση E-mail: "+strings.get(3));
        System.out.println("Ημερομηνία Γέννησης: "+strings.get(4));
        System.out.println("Αριθμός ΑΜΚΑ: "+strings.get(5));
    }

    static void showMenu(){
        System.out.println("\n1. Προβολή όλων των διαθέσιμων επαφών");
        System.out.println("2. Προσθήκη νέας επαφής");
        System.out.println("3. Αναζήτηση επαφής βάσει ονόματος");
        System.out.println("4. Επεξεργασία επαφής βάσει ονόματος");
        System.out.println("5. Διαγραφή επαφής βάσει ονόματος");
        System.out.println("6. Έξοδος απο το ευρετήριο");
        System.out.println("Παρακαλώ δώστε την επιλογή σας");
    }
}
