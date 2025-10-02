package Ex3;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nr: ");
        int nr = scanner.nextInt();

        for(int d = 1; d <= nr; d++) {
            if(nr % d == 0) {
                System.out.print(" " + d);
            }
        }

        scanner.close();
    }
}
