package Lab2_ex4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*4. Să se realizeze un program care citește numele si CNP-ul pe care îl au n persoane.
Valoarea lui n se citește de la tastatură. Programul va afișa informațiile introduse și în plus
pentru fiecare persoana va afișa vârsta. Cât timp un CNP-ul este introdus greșit programul va
cere reintroducerea acestuia. Pentru simplitate se consideră că CNP-ul este valid dacă
îndeplinește următoarele condiții:
• Are 13 caractere
• Toate caracterele sunt cifre
• Prima cifră are una din valorile 1, 2, 5, 6
• Cifra de control a CNP-ului are o valoare validă.

Se va crea clasa Persoana cu variabile membre private nume (String) şi cnp (String).
Clasa va avea constructor cu parametri, gettere si settere în funcție de necesități şi metoda
getVarsta() care va calcula şi va returna vârsta persoanei extrăgând data nașterii din CNP şi
citind din sistem data curentă. Se va utiliza clasa LocalDate. Se va crea un vector în care se
vor adăuga obiectele de tip Persoana. Fiecare element din vectorul va fi afișat pe un rând în
formatul nume, CNP, varsta.

Exemple CNP:
-------
5030126248382
5050713246754
*/

public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Persoana> persoane = new ArrayList<>();

        System.out.println("Introduceti numarul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consuma enterul ramas pentru a le pune una sub alta la completare

        for(int i = 0; i < n; i++) {
            System.out.println("\nPersoana " + (i + 1) + ": "); // afiseaza persoana si nr ul in ordine cronologica

            System.out.print("Nume: ");
            String nume = scanner.nextLine();

            String cnp;
            Persoana p;
            while (true) {
                System.out.print("CNP: "); // completezi cnp ul
                cnp = scanner.nextLine();
                p = new Persoana(nume, cnp); // creaza persoana cu nume si cnp ul

                if(p.validareCNP()) break; // validarea cnp ului
                else {
                    System.out.println("CNP invalide");
                }

            }
            persoane.add(p); // adauga persoana in lista dupa verificari

        }
        for(Persoana pers : persoane) // parrcurge lista pentru a afisa fiecare element
            pers.afiseazaDetalii();


        scanner.close();
    }
}
