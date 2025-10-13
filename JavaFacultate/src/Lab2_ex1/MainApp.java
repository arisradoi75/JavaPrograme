package Lab2_ex1;
import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class MainApp {
    /*Fișierul judete_in.txt, conține lista neordonată a județelor din țară. Să se încarce
datele din fișier într-un tablou de String-uri și să se ordoneze acest tablou cu ajutorul metodei
sort() din clasa Arrays. Să se returneze pe ce poziție se află în vectorul ordonat un județ
introdus de la tastatură. Se va utiliza metoda de căutare binară din clasa Arrays. */
    public static void main(String[] args) {
        try {
            File file = new File("/Users/arisradoi/Desktop/java projects/JavaPrograme/JavaFacultate/src/Lab2_ex1/judete_in.txt");
            Scanner fileScanner = new Scanner(file);

            List<String>listaJudete = new ArrayList<>(); // crearea unei liste goale unde vor fii adaugate datele din fisier

            while (fileScanner.hasNextLine()) { // citirea datelor din fisier , hasNextLine() - citeste lista pana la spatiu gol
                String judet = fileScanner.nextLine(); // crearea unui string judet care este atribuita val din fisier
                listaJudete.add(judet); // adaugarea propriu zisa in lista goala creata anterior
            }
            String[] judete = listaJudete.toArray(new String[0]); // transforma lista intr un array
            Arrays.sort(judete); // metoda de sortare care mi o cere in problema
            for(String s : judete) {
                System.out.println(s); // parcurgerea listei cu judete
            }

            Scanner  scanner = new Scanner(System.in);
            System.out.println("Introduceti un judet: ");
            String judetCautat = scanner.nextLine();

            int pozitie = Arrays.binarySearch(judete, judetCautat); // initializam o variabila pozitie cu care folosim metoda de binatysearch
            if(pozitie >= 0) {
                System.out.println(pozitie); // dupa conditia ca pozitia sa fie diferita de 0 iti afiseaza pozitia unde se localizeaza jduetul cautat
            } else
            {
                System.out.println("Nu a fost gasit");
            }


            fileScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }
    }
}
