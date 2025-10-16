package Lab3_ex2;
import java.time.LocalDate;

public class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirare;
    public static double incasari = 0;

    public Produs(String denumire, double pret, int cantitate, LocalDate dataExpirare) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirare = dataExpirare;
        this.incasari = incasari;
    }
    public String getDenumire() {
        return denumire;
    }
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
    public double getPret() {return pret;}
    public void setPret(double pret) {this.pret = pret;}
    public int getCantitate() {return cantitate;}
    public void setCantitate(int cantitate) {this.cantitate = cantitate;}
    public LocalDate getDataExpirare() {return dataExpirare;}
    public void setDataExpirare(LocalDate dataExpirare) {this.dataExpirare = dataExpirare;}

    public void afisareExpirare(){
        boolean gasit = false;
        if(dataExpirare.isBefore(LocalDate.now())){
            System.out.println(toString());
            gasit = true;
            if(!gasit){
                System.out.println("Nu exista produs!");
            }
        }
    }

    public void vindeProdus(int cantitateCeruta){
        if(cantitateCeruta > cantitate){
            System.out.println("Stoc insuficient!");
            return;
        }
        cantitate =- cantitateCeruta;

        double sumaVanzare = cantitateCeruta * pret;
        incasari += sumaVanzare;

        System.out.println("Suma incasata: " + sumaVanzare + "ron");
        System.out.println("Incasari totale: " + incasari);

        if(cantitate == 0){
            System.out.println("Produsul " + denumire + "s-a terminat");
        }
        else {
            System.out.println("Produsul " + denumire + "a ramas cu cantitatea de : " + cantitate + "grame");
        }
    }

    @Override
    public String toString() {
        return "Produs{" +
                "denumire= " + denumire  +
                ", pret= " + pret + " ron" +
                ", cantitate= " + cantitate + " grame" +
                ", data expirare= " + dataExpirare +
                '}';
    }
}
