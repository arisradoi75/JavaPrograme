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


        List<Vers> versuri = new ArrayList<>();

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
            for (Vers v : versuri) {
                double x = random.nextDouble();
                String textFinal = v.getText();

                if (x < 0.1) {
                    textFinal = v.majuscule();
                }
                int nrCuvinte = v.numarCuvinte();
                int nrVoclae = v.numarVocale();
                String linie = String.format("%s (Cuvinte: %d , Vocale: %d)", textFinal, nrCuvinte, nrVoclae);

                if(v.seTerminaCu(grupare)){
                    linie += " *";
                }
                System.out.println("Fisierul a fost creat!");
                fileWriter.println(linie);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
