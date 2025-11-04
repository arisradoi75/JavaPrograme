package lab5_ex_3_tema;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.sql.SQLOutput;
import java.util.*;

public class MainApp {
    public static List<Mobilier> citire() {
        try{
            File file = new File("/Users/arisradoi/Desktop/java projects/JavaFacultate/Maven_lab5/src/main/resources/mobilier.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Mobilier> mobiliere = objectMapper.readValue(file , new TypeReference<List<Mobilier>>(){});
            return mobiliere;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mobilier> mobiliere = citire();

        while(true){
            System.out.println("Alege optiune");
            System.out.println("1.Afiseaza Mobilier");
            System.out.println("2.Afiseaza elementele de mobilier si placile care le compun");
            System.out.println("3.Afiseaza caracteristicile placilor care compun o piesa de mobilier");
            System.out.println("4.Afiseaza numarul colilor");
            System.out.println("0.Iesire");

            int optiune =  scanner.nextInt();
            if(optiune == 0){ break;}

            switch(optiune){
                case 1:
                    for(Mobilier m : mobiliere){
                        System.out.println(m);
                    }
                    break;

                case 2:
                    for(Mobilier m : mobiliere){
                        System.out.println("Mobilier: " + m);
                        for(Placa p : m.getPlaci()){
                            System.out.println(" " + p);
                        }
                    }
                    break;

                case 3:
                    for(int i = 0; i < mobiliere.size(); i++){
                        System.out.println((i + 1) + ". " + mobiliere.get(i).getNume());
                    }
                    System.out.println("Introdu indexul dorit: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if(index < 0 || index > mobiliere.size()){
                        System.out.println("Index invalid!");
                    }
                    else{
                        Mobilier selectat = mobiliere.get(index);
                        for(int i=0;i<selectat.getPlaci().size();i++){
                            Placa p = selectat.getPlaci().get(i);
                            System.out.println(" [" + (i + 1) + "] " + p);
                        }
                    }
                    break;

                case 4:
                    for(int i = 0; i < mobiliere.size(); i++){
                        System.out.println((i + 1) + ". " + mobiliere.get(i).getNume());
                    }
                    System.out.println("Introdu indexul dorit: ");
                    int indx = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if(indx < 0 || indx > mobiliere.size()){
                        System.out.println("Index invalid!");
                    }
                    else{
                        Mobilier selectat = mobiliere.get(indx);
                        double totalSuprafata = 0;
                        for(Placa p : selectat.getPlaci()){
                            totalSuprafata += p.getLatime() * p.getLungime() * p.getNr_bucati();
                        }

                        double suprafataCola = 2800 * 2070;
                        double necesarColi = totalSuprafata / suprafataCola;

                        System.out.printf("\nNecesar estimativ de coli PAL pentru %s: %.2f%n", selectat.getNume(), necesarColi);

                    }

                    break;

                default:
                    System.out.println("Optiune invlaida");
                    break;
            }
        }

    }
}
