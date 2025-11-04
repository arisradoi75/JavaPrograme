package lab6;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jdk.jfr.Recording;

public class MainApp {
    public static List<Angajat> citire() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file = new File("/Users/arisradoi/Desktop/java projects/JavaFacultate/Maven_lab5/src/main/resources/angajati.json");
            List<Angajat> angajati = objectMapper.readValue(file, new TypeReference<List<Angajat>>() {
            });
            return angajati;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        List<Angajat> angajati = citire();
        Scanner scanner = new Scanner(System.in);
        //subpunctul a
        angajati.forEach(angajat -> System.out.println(angajat.toString()));

        System.out.println("=========Salariu peste 2500 lei==========");
        angajati.stream()
                .filter(angajat -> angajat.getSalariu() > 2500).forEach(angajat -> System.out.println(angajat.toString()));

        System.out.println("========Creare lista dupa functie si luna aprilie===========");

        var anCurent = LocalDate.now().getYear();
        var anulTrecut = LocalDate.now().getYear() - 1;

        var angajatiAprilieSef = angajati.stream()
                .filter(angajat -> angajat.getData_angajarii().getYear() == anulTrecut)
                .filter(angajat -> angajat.getData_angajarii().getMonth() == Month.APRIL)
                .filter(angajat -> angajat.getPost().toLowerCase().contains("sef") ||
                        angajat.getPost().toLowerCase().contains("director"))
                .collect(Collectors.toList());

        angajatiAprilieSef.forEach(angajat -> System.out.println(angajat.toString()));

        System.out.println("========Subpunctul 4============");
        var angajatiAprilieDirector = angajati.stream()
                .filter(angajat -> !angajat.getPost().toLowerCase().contains("director") && !angajat.getPost().toLowerCase().contains("sef"))
                .sorted((a1,a2) -> Float.compare(a2.getSalariu(), a1.getSalariu()))
                .collect(Collectors.toList());

        angajatiAprilieDirector.forEach(angajat -> System.out.println(angajat.toString()));

        System.out.println("=========Nume angajati cu majuscule=============");
        List<String> numeMajuscule = angajati.stream()
                .map(angajat -> angajat.getNume().toUpperCase())
                .collect(Collectors.toList());
        numeMajuscule.forEach(System.out::println);


        System.out.println("============Subpunctul 6==============");
        angajati.stream()
                .filter(angajat -> angajat.getSalariu() < 3000).forEach(angajat -> System.out.println(angajat.getNume().toUpperCase()));

        System.out.println("============Subpunctul 7============");

        Optional<Angajat> primulAngajat = angajati.stream()
                .min(Comparator.comparing(angajat -> angajat.getData_angajarii()));
        System.out.println("Primul angajat este: " + primulAngajat);

        System.out.println("============Subpunctul 8==============");
        System.out.println(angajati.stream().collect(Collectors.summarizingDouble(Angajat::getSalariu)));

        System.out.println("===========Subpunctul 9===============");
        angajati.stream()
                .filter(angajat -> angajat.getNume().equalsIgnoreCase("Ion"))
                .findAny()
                .ifPresentOrElse(angajat -> System.out.println("Firma are cel putin un Ion") , () -> System.out.println("Firma nu are un Ion"));

        System.out.println("=============Subpunctul 10================");

        long nrAngajati = angajati.stream()
                .filter(angajat -> angajat.getData_angajarii().getYear() == anulTrecut)
                .filter(angajat -> angajat.getData_angajarii().getMonth() == Month.JUNE || angajat.getData_angajarii().getMonth() == Month.JULY || angajat.getData_angajarii().getMonth() == Month.AUGUST)
                .count();

        System.out.println("Nr angajati: " + nrAngajati);

    }
}
