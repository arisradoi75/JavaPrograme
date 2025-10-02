package Ex4;
import java.util.Scanner;
import java.util.Random;

public class MainApp {
    /*Să se determine cmmdc a două numere naturale, a căror valoare maximă este 30. Numerele
        vor fi generate aleatoriu cu ajutorul unui obiect de tip Random și metodei nextInt();*/
        public static int cmmdc(int a , int b){
            while(b != 0){ // punem conditia ca unu din nr sa fie diferit de 0;
                int r =  a % b;
                a = b;
                b = r;
            }
            return a;
        }

    public static void main(String[] args) {
        Random r = new Random();

        int a = r.nextInt(31);
        int b = r.nextInt(31);

        int rezultat = cmmdc(a , b);
        System.out.println("a=" + a + " b=" + b);
        System.out.println(rezultat);

    }

}
