package lab7_ex2;

public class Chitara extends InstrumentMuzical{

    private Tip_chitara tipChitara;
    private int nrCorzi;

    public Chitara(){}

    public Chitara(Tip_chitara tipChitara, int nrCorzi , String producator , double pret) {
        super(producator , pret);
        this.tipChitara = tipChitara;
        this.nrCorzi = nrCorzi;
    }

    public Tip_chitara getTipChitara() {
        return tipChitara;
    }

    public void setTipChitara(Tip_chitara tipChitara) {
        this.tipChitara = tipChitara;
    }

    public int getNrCorzi() {
        return nrCorzi;
    }

    public void setNrCorzi(int nrCorzi) {
        this.nrCorzi = nrCorzi;
    }
    @Override
    public String toString() {
        return "Chitara{" +
                "tipChitara=" + tipChitara +
                ", nrCorzi=" + nrCorzi +
                '}';
    }
}
