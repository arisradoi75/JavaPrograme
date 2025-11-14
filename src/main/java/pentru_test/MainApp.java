package pentru_test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Autoturism> autoturisme = new ArrayList<>();

        try{
            Scanner fileScanner = new Scanner(new File("/Users/arisradoi/Desktop/java projects/JavaFacultate/Maven_lab5/src/main/resources/dateTest.csv"));
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                try{
                    String tip =  parts[0].trim();
                    String firma =  parts[1].trim();
                    Combustibil combustibil = Combustibil.valueOf(parts[2].trim());

                    switch(tip.toLowerCase()){
                        case "masina":
                            double pret = Double.parseDouble(parts[3].trim());
                            String model = parts[4].trim();
                            autoturisme.add(new Masina(firma ,combustibil, pret, model));
                            break;
                            case "motocicleta":
                                LocalDate dataFabricatiei = LocalDate.parse(parts[3].trim());
                                autoturisme.add(new Motocicleta(firma ,combustibil,dataFabricatiei));
                                break;

                                default:
                                    System.out.println("Erroare!");
                                break;
                    }

                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }
            fileScanner.close();
        }catch(IOException s){
            System.out.println("Error!");
        }
        System.out.println("Lista de autoturisme: ");
        autoturisme.forEach(System.out::println);

        System.out.println("Scrieti o frima de autoturisme: ");
        String firmaCautata = scanner.nextLine();

        while(!firmaCautata.matches("[a-zA-Z]+")){
            System.out.println("Introduceti doar litere");
            firmaCautata = scanner.nextLine();
        }
        if(autoturisme.get(0).getFirma().equalsIgnoreCase(firmaCautata)){
            System.out.println("Primul autoturism din lista este compatibil cu firma");
        } else{
            System.out.println("NU!");
        }

        System.out.println("Introduceti tipul de combustibil (BENZINA/MOTORINA): ");
        String tipCombustibil = scanner.nextLine().toUpperCase();

        try{
            Combustibil combustibilEnum =  Combustibil.valueOf(tipCombustibil);
            autoturisme.stream()
                    .filter(a -> a.getCombustibil() == combustibilEnum)
                    .forEach(System.out::println);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        autoturisme.stream()
                .filter(a -> a instanceof Motocicleta)
                .map(a -> (Motocicleta)a)
                .forEach(m -> System.out.println(m + " vechime: " + m.calculeazaVechime() + "ani"));

        autoturisme.stream()
                .filter(a -> a instanceof Motocicleta)
                .map(a -> (Motocicleta)a)
                .min((m1 , m2) -> m1.getDataFabricatiei().compareTo(m2.getDataFabricatiei()))
                .ifPresentOrElse(
                        m -> System.out.println("Cea ma veche: " + m),
                        () -> System.out.println("Nu exista")
                );

    }
}
