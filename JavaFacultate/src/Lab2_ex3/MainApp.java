package Lab2_ex3;
import java.util.*;
import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {
        /*Să se insereze într-o anumită poziție a unui șir de caractere, un alt șir. Datele vor fi
        preluate de la tastatură sau din fișier. Să se șteargă o porțiune a unui șir de caractere care
        începe dintr-o anumită poziție și are un anumit număr de caractere. Se recomandă utilizarea
        clasei StringBuilder.*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti sirul initial: ");
        String sir = scanner.nextLine();

        StringBuilder text = new StringBuilder(sir);

        System.out.println("Introduceti sirul care trebuie inserat: ");
        String deInserat = scanner.nextLine();

        System.out.println("Introduceti de la ce pozitie sa inceapa: ");
        int pozitie = scanner.nextInt();

        if(pozitie >=0 && pozitie <= text.length()){
            text.insert(pozitie, deInserat);
            System.out.println(text.toString());
        }

        System.out.println("Introduceti de unde sa inceapa stergerea: ");
        int pozitieStergere = scanner.nextInt();

        System.out.println("Introduceti nr de caractere: ");
        int nrCaractere = scanner.nextInt();

        int pozitieFinala = pozitieStergere +  nrCaractere;
        if(pozitieFinala >=0 && pozitieFinala <= text.length()){
            text.delete(pozitieStergere , pozitieFinala);
            System.out.println("Dupa stergere: " + text.toString());
        }
        else{
            System.out.println("Parametrii invalizi");
        }

        scanner.close();
    }
}
