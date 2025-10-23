package Lab4;
import Lab4.enumurile.*;

public class SistemeDeCalcul extends Echipament{
    private String tip_mon;
    private String vit_proc;
    private String c_hdd;
    private modSistemOperare modSistemOperare;

    public SistemeDeCalcul(String denumire, int nr_inv, double pret, String zona_mag , stareProdus stare , String tip_mon , String vit_proc , String c_hdd , modSistemOperare modSistemOperare) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.modSistemOperare = modSistemOperare;
    }

    public String getTip_mon() {
        return tip_mon;
    }

    public String getVit_proc() {
        return vit_proc;
    }

    public String getC_hdd() {
        return c_hdd;
    }

    public modSistemOperare getModSistemOperare() {
        return modSistemOperare;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public void setVit_proc(String vit_proc) {
        this.vit_proc = vit_proc;
    }

    public void setModSistemOperare(modSistemOperare modSistemOperare) {
        this.modSistemOperare = modSistemOperare;
    }

    public void setC_hdd(String c_hdd) {
        this.c_hdd = c_hdd;
    }

    @Override
    public String toString() {
        return "SistemCalcul{" +
                "denumire='" + getDenumire() + '\'' +
                ", nr_inv=" + getNr_inv() +
                ", pret=" + getPret() +
                ", zona_mag='" + getZona_mag() + '\'' +
                ", stare=" + getStare() +
                ", tip_mon='" + tip_mon + '\'' +
                ", vit_proc='" + vit_proc + '\'' +
                ", c_hdd='" + c_hdd + '\'' +
                ", sistem_operare=" + modSistemOperare +
                '}';
    }
}
