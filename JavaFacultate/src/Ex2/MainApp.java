package Ex2;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double perimetru;
        double arie;


        System.out.println("Lungime: ");
        double lungime = scanner.nextDouble();

        System.out.println("Latime: ");
        double latime = scanner.nextDouble();

        perimetru = 2 * (lungime + latime);
        arie = lungime * latime;

        System.out.println("Perimetru: " + perimetru);
        System.out.println("Arie: " + arie);


        scanner.close();
    }
}
