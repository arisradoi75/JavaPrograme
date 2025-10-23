package Lab4;

import Lab4.enumurile.stareProdus;
import Lab4.enumurile.modTiparire;

public class Imprimante extends Echipament{
    private int ppm;
    private int dpi;
    private int p_car;
    private modTiparire mod_scriere;

    public Imprimante(String denumire, int nr_inv, double pret, String zona_mag , stareProdus stare , int ppm , int dpi, int p_car, modTiparire mod_scriere) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.mod_scriere = mod_scriere;
    }

    public int getPpm() {
        return ppm;
    }

    public int getDpi() {
        return dpi;
    }

    public int getP_car() {
        return p_car;
    }

    public modTiparire getMod_scriere() {
        return mod_scriere;
    }

    public void setMod_scriere(modTiparire mod_scriere) {
        this.mod_scriere = mod_scriere;
    }

    @Override
    public String toString() {
         return "Imprimanta{" +
                "denumire='" + getDenumire() + '\'' +
                ", nr_inv=" + getNr_inv() +
                ", pret=" + getPret() +
                ", zona_mag='" + getZona_mag() + '\'' +
                ", stare=" + getStare() +
                ", ppm=" + ppm +
                ", dpi=" + dpi +
                ", p_car=" + p_car +
                ", mod_scriere=" + mod_scriere +
                '}';
    }
}
