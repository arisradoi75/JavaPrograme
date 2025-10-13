package Lab2_ex2;
import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;

/*Fișierul cantec_in.txt conține versurile unui cântec la alegere. Să se scrie un
program care creează fișierul cantec_out.txt, care conține versurile cântecului original dar în
plus în dreptul fiecărui rând sunt afișate numărul de cuvinte de pe rând şi numărul de vocale
de pe fiecare rând. În dreptul rândurilor care se încheie cu o grupare de litere aleasă se va
pune o steluță (*). Rândurile pentru care un număr generat aleator este mai mic decât 0.1 vor
fi scrise cu majuscule (se vor genera aleator numere între 0 şi 1).
Se va defini o clasă Vers, care are o variabilă membră privată un șir de caractere
reprezentând versul și se va dezvolta câte un operator pentru fiecare cerință de mai sus (o
metodă care returnează numărul de cuvinte, o metodă care returnează numărul de vocale, etc).
Se va crea un vector de obiecte de tip Vers care va conține informația preluată din fișierul de
intrare. */

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        List<Vers> versuri = new ArrayList<>(); // lista de versuri

        System.out.println("Introduceti o grupare de cuvinte: ");
        String grupare = scanner.nextLine().trim();

        try{
        Scanner fileScanner = new Scanner(new File("/Users/arisradoi/Desktop/java projects/JavaPrograme/JavaFacultate/src/Lab2_ex2/cantec_in.txt"));
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            versuri.add(new Vers(line));
            }
        }
        catch(FileNotFoundException e){
        System.out.println("File not found!");
        }

        try (PrintWriter fileWriter = new PrintWriter("cantec_out.txt")) {
            for (Vers v : versuri) { // folosim un for pentru parcurgerea listei de versuri
                double x = random.nextDouble(); // generam un numar random x
                String textFinal = v.getText(); // cream o variabila caruia ii atribuim textul

                if (x < 0.1) { // punem coniditia ca x <0.1
                    textFinal = v.majuscule(); // scriem versul cu majuscule
                }
                int nrCuvinte = v.numarCuvinte(); // metoda de citire a nr de cuvinte apelata din clasa Vers
                int nrVoclae = v.numarVocale(); // aceasi chestie doar ca cu vocale
                String linie = String.format("%s (Cuvinte: %d , Vocale: %d)", textFinal, nrCuvinte, nrVoclae); // afisarea nr ului de cuvinte si nr ului de vocale

                if(v.seTerminaCu(grupare)){
                    linie += " *"; // adaugam stea unde se termina cu gruparea citita mai sus
                }
                System.out.println("Fisierul a fost creat!");
                fileWriter.println(linie); // scriem in fisier rezultatele
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
