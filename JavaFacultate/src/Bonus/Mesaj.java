package Bonus;
import java.io.*;


public class Mesaj implements Serializable{

    private String nume;
    private String continut;
    public Mesaj(String nume, String continut) {
        this.nume = nume;
        this.continut = continut;
    }

    public String getContinut() {
        return continut;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    @Override
    public String toString() {
        return "Mesaj{" +
                "nume='" + nume + '\'' +
                ", continut='" + continut + '\'' +
                '}';
    }
}
