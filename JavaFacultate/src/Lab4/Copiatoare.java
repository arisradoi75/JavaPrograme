package Lab4;
import Lab4.enumurile.modCopiere;
import Lab4.enumurile.stareProdus;

public class Copiatoare extends Echipament{
    private int p_ton;
    private modCopiere mod_copiere;

    public Copiatoare(String denumire, int nr_inv, double pret, String zona_mag , stareProdus stare , int p_ton , modCopiere mod_copiere) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.mod_copiere = mod_copiere;
    }

    public int getP_ton() {
        return p_ton;
    }

    public modCopiere getMod_copiere() {
        return mod_copiere;
    }

    public void setP_ton(int p_ton) {
        this.p_ton = p_ton;
    }
    public void setMod_copiere(modCopiere mod_copiere) {
        this.mod_copiere = mod_copiere;
    }

    @Override
    public String toString() {
        return "Copiator{" +
                "denumire='" + getDenumire() + '\'' +
                ", nr_inv=" + getNr_inv() +
                ", pret=" + getPret() +
                ", zona_mag='" + getZona_mag() + '\'' +
                ", stare=" + getStare() +
                ", p_ton=" + p_ton +
                ", mod_copiere=" + mod_copiere +
                '}';
    }

}
