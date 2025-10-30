package lab5_ex_2_tema;
import java.io.File;
import java.util.*;
import java.io.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class MainApp {
    public static void scriere(List<PerecheNumere>lista) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("/Users/arisradoi/Desktop/java projects/JavaFacultate/Maven_lab5/src/main/resources/perechenumere.json");


        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<PerecheNumere> citire() {
        try{
            File file = new File("/Users/arisradoi/Desktop/java projects/JavaFacultate/Maven_lab5/src/main/resources/perechenumere.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<PerecheNumere> perecheNumere = objectMapper.readValue(file, new TypeReference<List<PerecheNumere>>() {
            });

            return perecheNumere;

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }


    public static void main (String[]args){
        List<PerecheNumere> numere = citire();
        System.out.println(numere);
        for(PerecheNumere p : numere) {
            System.out.println(p);
        }
        numere.add(new PerecheNumere(2, 3));
        scriere(numere);

            for (PerecheNumere p : numere) {
                System.out.println(p.suntConsecutiveFibonacci());
            }
    }
}

