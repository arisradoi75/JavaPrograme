package lab7_ex2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class InstrumentMuzical {
    private String producator;
    private double pret;

    public InstrumentMuzical() {}

    public InstrumentMuzical(String producator, double pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getProducator() {
        return producator;
    }

    public double getPret() {
        return pret;
    }

    @Override
    public String toString() {
        return "InstrumentMuzical{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }
}
