package lab5_ex_3_tema;
import lab5_ex_3_tema.enumerare.Orientare;

import java.util.Arrays;

public class Placa {
    private String descriere;
    private int lungime;
    private int latime;
    private Orientare orientare;
    private boolean[] canturi;
    private int nr_bucati;
    public Placa(){}

    public Placa(String descriere, int lungime, int latime, Orientare orientare , boolean[] canturi, int nr_bucati) {
        if(canturi == null || canturi.length != 4){
            throw new IllegalArgumentException("canturi array must contain 4 elements");
        }

        this.descriere = descriere;
        this.lungime = lungime;
        this.latime = latime;
        this.orientare = orientare;
        this.canturi = new boolean[lungime];
        this.nr_bucati = nr_bucati;
    }

    public String getDescriere() {
        return descriere;
    }

    public int getLatime() {
        return latime;
    }

    public int getLungime() {
        return lungime;
    }

    public boolean[] getCanturi() {
        return canturi;
    }

    public Orientare getOrientare() {
        return orientare;
    }

    public int getNr_bucati() {
        return nr_bucati;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }

    public void setOrientare(Orientare orientare) {
        this.orientare = orientare;
    }

    public void setCanturi(boolean[] canturi) {
        this.canturi = canturi;
    }

    public void setNr_bucati(int nrBucati) {
        this.nr_bucati = nrBucati;
    }

    @Override
    public String toString() {
        return "Placa{" +
                "descriere='" + descriere + '\'' +
                ", lungime=" + lungime +
                ", latime=" + latime +
                ", orientare=" + orientare +
                ", canturi=" + Arrays.toString(canturi) +
                ", nrBucati=" + nr_bucati +
                '}';
    }
}
