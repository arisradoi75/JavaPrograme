package Lab4;
import java.util.*;
import java.io.*;
import Lab4.enumurile.*;

import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        List<Echipament> listaEchipament = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            Scanner filescaner = new Scanner(new File("/Users/arisradoi/Desktop/java projects/JavaPrograme/JavaFacultate/src/Lab4/electronice.txt"));
            while (filescaner.hasNextLine()) {
                String line = filescaner.nextLine();
                String[] parts = line.split(";");
                String tip = parts[0].trim();

                String denumire = parts[1].trim();
                int nr_inv = Integer.parseInt(parts[2].trim());
                double pret = Double.parseDouble(parts[3].trim());
                String zona_mag = parts[4].trim();
                stareProdus stare = stareProdus.valueOf(parts[5].trim().toUpperCase());

                switch (tip.toLowerCase()) {
                    case "imprimanta":
                        int ppm = Integer.parseInt(parts[6].trim());
                        int dpi = Integer.parseInt(parts[7].trim());
                        int p_car = Integer.parseInt(parts[8].trim());
                        modTiparire mod_scriere = modTiparire.valueOf(parts[9].trim().toUpperCase());
                        listaEchipament.add(new Imprimante(denumire, nr_inv, pret, zona_mag, stare, ppm, dpi, p_car, mod_scriere));
                        break;

                    case "copiator":
                        int p_ton = Integer.parseInt(parts[6].trim());
                        modCopiere mod_copiere = modCopiere.valueOf(parts[7].trim());
                        listaEchipament.add(new Copiatoare(denumire, nr_inv, pret, zona_mag, stare, p_ton, mod_copiere));
                        break;

                    case "sistem_calcul":
                        String tip_mon = parts[6].trim();
                        String vit_proc = parts[7].trim();
                        String c_hdd = parts[8].trim();
                        modSistemOperare modSisteme = modSistemOperare.valueOf(parts[9].trim().toUpperCase());
                        listaEchipament.add(new SistemeDeCalcul(denumire, nr_inv, pret, zona_mag, stare, tip_mon, vit_proc, c_hdd, modSisteme));
                        break;
                    default:
                        System.out.println("Optiune invalida!");
                        break;
                }

            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }
        while (true) {
            System.out.println("Alegeti o optiune: ");
            System.out.println("1.Afisarea tuturor echipamentelor");
            System.out.println("2.Afisarea imprimantelor");
            System.out.println("3.Afisarea copiatorelor");
            System.out.println("4.Afisarea sistemelor de calcul");
            System.out.println("5.Modificarea starii in care se afla un echipament");
            System.out.println("6.Setarea unui format de copiere pentru copiatoare");
            System.out.println("7.Instalarea unui anumit sistem de operare");
            System.out.println("9.Afisarea echipamentelor vandute");
            System.out.println("10.Serializare");
            System.out.println("11.Deserializare");
            System.out.println("0.Iesire");

            int optiune = scanner.nextInt();
            if (optiune == 0) break;

            switch (optiune) {
                case 1:
                    for (Echipament e : listaEchipament) {
                        System.out.println(e.toString());
                    }
                    break;
                case 2:
                    for (Echipament e : listaEchipament) {
                        if (e instanceof Imprimante) {
                            System.out.println(e.toString());
                        }
                    }
                    break;

                case 3:
                    for (Echipament e : listaEchipament) {
                        if (e instanceof Copiatoare) {
                            System.out.println(e.toString());
                        }
                    }
                    break;

                case 4:
                    for (Echipament e : listaEchipament) {
                        if (e instanceof SistemeDeCalcul) {
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 5:
                   for(int i = 0 ; i < listaEchipament.size(); i++){
                       System.out.println(i + 1 + ": " + listaEchipament.get(i));
                   }
                    System.out.println("Introduceti indexul: ");
                   int index = scanner.nextInt() - 1;

                   if(index >= 0 && index < listaEchipament.size()) {
                       Echipament e = listaEchipament.get(index);
                       System.out.println("Starea curenta: " + e.getStare());

                       System.out.println("Alegeti noua stare: (VANDUT , EXPUS , ACHIZITIONAT)");
                       String nouaStare = scanner.next().toUpperCase();

                       try {
                           e.setStare(stareProdus.valueOf(nouaStare));
                           System.out.println("Starea a fost actualizata!");

                       } catch (Exception ex) {
                           System.out.println(ex.getMessage());
                       }
                   } else {
                       System.out.println("Optiune invalida!");
                   }
                    break;

                case 6:
                    for (int i = 0; i < listaEchipament.size(); i++) {
                    Echipament e = listaEchipament.get(i);
                    if (e instanceof Imprimante) {
                        System.out.println(i + 1 + ": " + e);
                    }
                }
                    System.out.println("Alegeti indexul: ");
                    index = scanner.nextInt() - 1;
                    if(index >= 0 && index < listaEchipament.size()) {
                        Echipament e = listaEchipament.get(index);
                        System.out.println("Alegeti noul mod de scriere: (ALB_NEGRU sau COLOR)");
                        String nouMod = scanner.next().toUpperCase();

                        try{
                            modTiparire modNou = modTiparire.valueOf(nouMod);
                            ((Imprimante) e).setMod_scriere(modNou);
                            System.out.println("S-a modificat cu succes");

                        }   catch(Exception ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                    else {
                        System.out.println("Optiune invalida!");
                    }
                    break;

                case 7:
                    for(int i = 0; i < listaEchipament.size(); i++){
                        Echipament e = listaEchipament.get(i);
                        if(e instanceof Copiatoare) {
                            System.out.println(i + 1 + ": " + e);
                        }
                    }
                    System.out.println("Alegeti indexul: ");
                    index = scanner.nextInt() - 1;
                    if(index >= 0 && index < listaEchipament.size()) {
                        Echipament e = listaEchipament.get(index);
                        System.out.println("Alegeti noul format de copiere: (A3 sau A4)");
                        String nouFormat = scanner.next().trim().toUpperCase();

                        try{
                            modCopiere modNou = modCopiere.valueOf(nouFormat);
                            ((Copiatoare) e).setMod_copiere(modNou);
                            System.out.println("S-a modificat cu succes");
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;

                    case 8:
                        for(int i = 0; i < listaEchipament.size(); i++){
                            Echipament e = listaEchipament.get(i);
                            if(e instanceof SistemeDeCalcul) {
                                System.out.println(i + 1 + ": " + e);
                            }
                        }
                        System.out.println("Alegeti indexul: ");
                        index = scanner.nextInt() - 1;

                        if(index >= 0 && index < listaEchipament.size()) {
                            Echipament e = listaEchipament.get(index);
                            System.out.println("Alegeti noul mod de sistem de operare: (WINDOWS sau LINUX)");
                            String nouMod = scanner.next().toUpperCase();

                            try{
                                modSistemOperare modNou = modSistemOperare.valueOf(nouMod);
                                ((SistemeDeCalcul) e).setModSistemOperare(modNou);
                                System.out.println("S-a modificat cu succes");

                            }catch (Exception ex){
                                System.out.println(ex.getMessage());
                            }
                        }

                        case 9:
                            for(Echipament e : listaEchipament) {
                                if(e.getStare() == stareProdus.VANDUT) {
                                    System.out.println(e);
                                }
                            }
                        break;
                case 10:
                    Serializare.scrie(listaEchipament , "/Users/arisradoi/Desktop/java projects/JavaPrograme/JavaFacultate/src/Lab4/echip.bin");
                    System.out.println("A fost serializata cu succes");

                    break;

                case 11:
                    Object obj = Serializare.citeste("/Users/arisradoi/Desktop/java projects/JavaPrograme/JavaFacultate/src/Lab4/echip.bin");
                    if(obj != null) {
                        listaEchipament = (List<Echipament>) obj;
                        System.out.println("A fost deserializata cu succes");
                    }
                    else {
                        System.out.println("Eroare!");
                    }
                    break;

                default:
                    System.out.println("Optiune invalida!!");
                    break;
            }
        }

        scanner.close();
    }

}
