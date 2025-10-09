package Lab2_ex4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Persoana> persoane = new ArrayList<>();

        System.out.println("Introduceti numarul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consuma enterul ramas

        for(int i = 0; i < n; i++) {
            System.out.println("\nPersoana " + (i + 1) + ": ");

            System.out.print("Nume: ");
            String nume = scanner.nextLine();

            String cnp;
            Persoana p;
            while (true) {
                System.out.print("CNP: ");
                cnp = scanner.nextLine();
                p = new Persoana(nume, cnp);

                if(p.validareCNP()) break;
                else {
                    System.out.println("CNP invalide");
                }

            }
            persoane.add(p);

        }
        for(Persoana pers : persoane)
            pers.afiseazaDetalii();


        scanner.close();
    }
}
