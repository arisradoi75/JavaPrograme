package lab7_ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab6.Angajat;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {

    public static HashMap<Integer, Carte> citire() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/carti.json");
            return mapper.readValue(file, new TypeReference<HashMap<Integer, Carte>>() {
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new HashMap<>();
        }
    }
    public static void main(String[] args){
        var carti = citire();
        carti.forEach((id , carte) -> System.out.println(id + " " + carte));

        carti.remove(1); // stergere

        carti.putIfAbsent(10 , new Carte("Frumoasa cu 3 iezi" , "Mircea Eliade" , 2003)); // adaugare

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/carti.json") , carti);//writewithdefaultprettyprinter face ca json sa fie scris frumos
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Set<Carte> harari = carti.values().stream()
                .filter(c -> c.autorul().equals("Yuval Noah Harari"))
                .collect(Collectors.toSet());
        harari.forEach(System.out::println);


        harari.stream()
                .sorted(Comparator.comparing(Carte::titlul))
                .forEach(System.out::println);

        harari.stream()
                .min(Comparator.comparing(Carte::anul))
                .ifPresent(System.out::println);
    }
}
