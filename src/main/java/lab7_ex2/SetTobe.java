package lab7_ex2;

public class SetTobe extends InstrumentMuzical {
    private Tip_tobe tipTobe;
    private int nrTobe;
    private int nrCinele;

    public SetTobe() {}


    public SetTobe(Tip_tobe tipTobe, int nrTobe, int nrCinele , String producator , double pret) {
        super(producator , pret);
        this.tipTobe = tipTobe;
        this.nrTobe = nrTobe;
        this.nrCinele = nrCinele;
    }

    public Tip_tobe getTipTobe() {
        return tipTobe;
    }

    public void setTipTobe(Tip_tobe tipTobe) {
        this.tipTobe = tipTobe;
    }

    public int getNrTobe() {
        return nrTobe;
    }

    public void setNrTobe(int nrTobe) {
        this.nrTobe = nrTobe;
    }

    public int getNrCinele() {
        return nrCinele;
    }

    public void setNrCinele(int nrCinele) {
        this.nrCinele = nrCinele;
    }

    @Override
    public String toString() {
        return "SetTobe{" +
                "tipTobe=" + tipTobe +
                ", nrTobe=" + nrTobe +
                ", nrCinele=" + nrCinele +
                '}';
    }
}
