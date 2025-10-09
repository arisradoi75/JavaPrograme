package Lab2_ex4;

import java.time.LocalDate;

public class Persoana {
    private String nume;
    private String CNP;

    public Persoana(String nume, String CNP) {
        this.nume = nume;
        this.CNP = CNP;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCNP() {
        return CNP;
    }
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
    public int getVarsta(){
        int s = Character.getNumericValue(CNP.charAt(0));
        int an = Integer.parseInt(CNP.substring(1, 3));
        int luna = Integer.parseInt(CNP.substring(3, 5));
        int zi = Integer.parseInt(CNP.substring(5, 7));

        int secol = 0;
        if(s == 1 || s == 2 ) secol = 1900;
        else if (s == 5 || s == 6 ) secol = 2000;
        else System.out.println("Prima litera din cnp este invalida!");

        int anNastere = secol + an;
        LocalDate dataNasterii = LocalDate.of(anNastere , luna , zi);
        int azi = LocalDate.now().getYear();

        int varsta = 0;
        varsta = azi - anNastere;

        return varsta;
    }
    public boolean validareCNP() {
        char prima = CNP.charAt(0);
        if (prima != '1') {return false;}
        if (prima != '2') {return false;}
        if (prima != '5') {return false;}
        if (prima != '6') {return false;}

        for(int i=0;i<CNP.length();i++) {
            char c = CNP.charAt(i);
            if(c < '0' || c > '9') {return false;}
        }

        if(CNP.length()!=13) {return false;}

        return true;
    }

    public void afiseazaDetalii(){
        System.out.println("Numele persoanei: " + nume + " \nVarsta persoanei: " + getVarsta());
    }

}
