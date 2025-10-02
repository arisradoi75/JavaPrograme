package Ex1;
import java.util.Scanner;
import java.io.*; // pentru toate clasele din pachetul java.io

public class MainApp {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("/Users/arisradoi/Desktop/java projects/JavaPrograme/JavaFacultate/src/Ex1/in.txt"));
            int suma = 0;
            int media;
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            int count = 0;

            int n = 6;
            for(int i = 1; i <= n; i++) {
                int nr = scanner.nextInt();
                suma += nr;
                count++;

                if(nr < min)
                    min = nr;
                if(nr > max)
                    max = nr;
            }

            media = suma / count;

            System.out.println("Suma: " + suma);
            System.out.println("Media: " + media);
            System.out.println("Minimul: " + min);
            System.out.println("Maximul: " + max);

            PrintWriter out = new PrintWriter(new File("out.txt"));
            out.println("suma: " + suma);
            out.println("media: " + media);
            out.println("minim: " + min);
            out.println("maxim: " + max);

            out.close();
            scanner.close();
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }
}
