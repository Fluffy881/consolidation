package fr.dawan.genericite;

import fr.dawan.serialization.BIN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        // type string
        BoiteGeneric<String> boiteString = new BoiteGeneric<String>("hello world");
        System.out.println("contenue de la boite : " + boiteString.getContenu());

        // type numeric
        BoiteGeneric<Integer> boiteInteger = new BoiteGeneric<Integer>(12);
        System.out.println("contenue de la boite : " + boiteString.getContenu());


        boiteString.afficherContenue("Etiquette : ");
        boiteString.afficherContenue(5);


        System.out.println("-------------SERIALIZATION-------------");

        List<Product> lst = new ArrayList<Product>();
        lst.add(new Product(1,"pc",999.99));
        lst.add(new Product(2,"ecran",200.99));
        lst.add(new Product(3,"clavier",99.99));

        System.out.println("-------------BINAIRE-------------");

        try {
            BIN.encodeToFile(lst,"produit.bin");
            ((List<?>)BIN.decodeFromFile("produit.bin")).stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
