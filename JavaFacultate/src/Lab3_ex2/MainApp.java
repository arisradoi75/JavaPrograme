package Lab3_ex2;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class MainApp {
    public static void main(String[] args) {
        List<Produs> listaProduse = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            Scanner fileScanner = new Scanner(new File("/Users/arisradoi/Desktop/java projects/JavaPrograme/JavaFacultate/src/Lab3_ex2/produse.csv"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String denumire = parts[0].trim();
                double pret = Double.parseDouble(parts[1].trim());
                int cantitate = Integer.parseInt(parts[2].trim());
                LocalDate dataExpirare = LocalDate.parse(parts[3].trim());

                Produs produs = new  Produs(denumire, pret, cantitate, dataExpirare);
                listaProduse.add(produs);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }

        while(true){
            System.out.println("Alegeti o optiune: ");
            System.out.println("1.Afisare produse");
            System.out.println("2.Afisare produse expirate");
            System.out.println("3.Vanzare produs");
            System.out.println("4.Afisare produse cu pret minim");
            System.out.println("5.Salvare produse cu o cantitate mai mica decat ... ");
            System.out.println("0.Iesire");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            if(optiune == 0) break;

            switch (optiune) {
                case 1:
                    for(Produs p : listaProduse) {
                        System.out.println(p.toString());
                    }
                    break;
                case 2:
                    for(Produs p : listaProduse) {
                        p.afisareExpirare();
                    }
                    break;
                case 3:
                    System.out.println("Produse disponibile: ");
                    for(int i=0;i<listaProduse.size();++i) {
                        System.out.println((i + 1) + "." + listaProduse.get(i).toString());
                    }
                    System.out.println("Selectati indexul produsului dorit: ");
                    int index = scanner.nextInt() - 1;

                    System.out.println("Introduceti cantitatea dorita: ");
                    int cantitate = scanner.nextInt();

                    Produs produsSelectat = listaProduse.get(index);
                    produsSelectat.vindeProdus(cantitate);

                    if(produsSelectat.getCantitate() == 0) {
                        listaProduse.remove(index);
                    }
                    break;
                case 4:
                    double pretMinim = listaProduse.get(0).getPret();
                    for(Produs p : listaProduse) {
                        if (p.getPret() < pretMinim) {
                            pretMinim = p.getPret();
                        }
                    }
                    System.out.println("Pretul minim: " + pretMinim + "ron");
                    for(Produs p : listaProduse) {
                        if(p.getPret() == pretMinim) {
                            System.out.println(p.toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Introduceti cantitatea dorita: ");
                    int cantitatea = scanner.nextInt();


                    try{
                        PrintWriter fileWriter = new PrintWriter("/Users/arisradoi/Desktop/java projects/JavaPrograme/JavaFacultate/src/Lab3_ex2/produse_stoc.txt");
                        for(Produs p : listaProduse) {
                            if(p.getCantitate() < cantitatea) {
                                fileWriter.println(p.toString());
                            }
                        }
                        fileWriter.close();
                        System.out.println("Produsele s-au salvat in fisier!");

                    } catch(Exception e){
                        System.out.println("File not found!!");
                    }

                    break;
                case 0: break;
                default:
                    System.out.println("Optiune invalida!");
                    break;
            }
        }
        scanner.close();
    }
}
