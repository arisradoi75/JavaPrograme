package lab7_ex2;

import java.io.File;
import java.io.IOException;
import java.lang.classfile.Instruction;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab7_ex2.Tip_chitara;
import org.w3c.dom.ls.LSOutput;

public class MainApp {
    public static void scriere(Set<InstrumentMuzical> s) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file = new File("src/main/resources/instrumente.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Set<InstrumentMuzical> citire() {
        try{
            File file = new File("src/main/resources/instrumente.json");
            ObjectMapper mapper = new ObjectMapper();
            Set<InstrumentMuzical> instrumente = mapper.readValue(file, new TypeReference<Set<InstrumentMuzical>>() {});
            System.out.println("Implementarea pentru Set este: " +  instrumente.getClass().getName());
            return instrumente;
        }catch (Exception e){
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }





    public static void main(String[] args) throws IOException {

        Set<InstrumentMuzical> instrumente = new HashSet<InstrumentMuzical>();
        instrumente.add(new Chitara(Tip_chitara.ELECTRICA , 6 , "JhonnyDeep" , 4500));
        instrumente.add(new Chitara(Tip_chitara.ACUSTICA , 6 , "AsoltaneiMusic" , 150));
        instrumente.add(new Chitara(Tip_chitara.ELECTRICA , 8 , "LazarMusic" , 350));
        instrumente.add(new Chitara(Tip_chitara.ELECTRICA , 12 , "SRLMusic" , 950));
        instrumente.add(new SetTobe(Tip_tobe.ACUSTICE , 6, 4 , "MariusSRL" , 450));
        instrumente.add(new SetTobe(Tip_tobe.ELECTRICE , 8, 6 , "ATENASRL" , 850));
        instrumente.add(new SetTobe(Tip_tobe.ELECTRICE , 10, 8 , "CRASPUNDSRL" , 1050));

        scriere(instrumente);

        Set<InstrumentMuzical> instrumenteMuzicale = citire();

        Chitara c = new Chitara(Tip_chitara.ACUSTICA , 6 , "AsoltaneiMusic" , 150);
        boolean rezultat = instrumente.add(c);

        if(rezultat){
            System.out.println("Nu a fost considerat dublicat , deci a set ul a permis adaugarea");
        } else {
            System.out.println("A fost considerat dublicat , deci a set ul a permis adaugare");
        }

        System.out.println("Stergerea unei chitare folosind removeIf");
        instrumenteMuzicale.removeIf(instrument -> instrument.getPret() > 3000 );
        System.out.println("Afisare dupa stergere");
        instrumenteMuzicale.forEach(System.out::println);


        System.out.println("Afisarea chitarelor folosind instanceof");
        instrumenteMuzicale.stream()
                .filter(instrumentMuzical -> instrumentMuzical instanceof Chitara)
                .forEach(instrumentMuzical -> System.out.println(instrumentMuzical.toString()));


        System.out.println("Afisarea tobelor folosind getClass()");
        instrumenteMuzicale.stream()
                .filter(instrumentMuzical -> instrumentMuzical.getClass().getSimpleName().equals("SetTobe"))
                .forEach(instrumentMuzical -> System.out.println(instrumentMuzical.toString()));

        System.out.println("Sa se afiseze datele chitarii care are cele mai multe corzi");
        instrumenteMuzicale.stream()
                .filter(instrument -> instrument instanceof Chitara)
                .map(instrument -> (Chitara) instrument)
                .max((c1,c2) -> c1.getNrCorzi() - c2.getNrCorzi())
                .ifPresent(instrument -> System.out.println("Chitara cu cele mai multe corzi: " + c));

        System.out.println("Aranjarea tobelor dupa numarul lor");
        instrumenteMuzicale.stream()
                .filter(instrument -> instrument instanceof SetTobe)
                .map(instrument -> (SetTobe) instrument)
                .filter(instrument -> instrument.getTipTobe() == Tip_tobe.ACUSTICE)
                .sorted(Comparator.comparing(SetTobe::getNrTobe))
                .forEach(System.out::println);






    }
}
