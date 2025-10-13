package Lab3_ex1;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class MainApp {
    public static void main(String[] args) {
        List<Parabola> parabole = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("/Users/arisradoi/Desktop/java projects/JavaPrograme/JavaFacultate/src/Lab3_ex1/in.txt"))) {
            while (fileScanner.hasNextLine()) {
                String linie = fileScanner.nextLine().trim();
                String[] parts = linie.split(" ");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);

                parabole.add(new Parabola(a, b, c));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
            return;
        }

        System.out.println("Afisarea parabolelor: ");
        for (Parabola p : parabole) {
            System.out.println(p);
            double[] varf = p.calcVirfParabola();
            System.out.println("(" + varf[0] + " , " + varf[1] + ")");
        }
        if (parabole.size() >= 2) {
            Parabola p1 = parabole.get(0);
            Parabola p2 = parabole.get(1);

            double[] mijloc = p1.mijlocParabola(p2);
            double lungime = p1.lungimeParabola(p2);
            double lungime2 = p2.lungimeParabola(p2);
            System.out.println("Mijlocul parabolei este: "+"(" + mijloc[0] + ", " + mijloc[1] + ")");
            System.out.println("Lungimea segmentului: " +  lungime);

        }else{System.out.println("Trebuie minim 2 parabole");}
    }
}
