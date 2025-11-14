package pentru_test;

import java.time.LocalDate;

public class Motocicleta extends Autoturism{
    private LocalDate dataFabricatiei;

    public Motocicleta(String frima , Combustibil combustibil,LocalDate dataFabricatiei){
        super(frima,combustibil);
        this.dataFabricatiei = dataFabricatiei;
    }

    public LocalDate getDataFabricatiei() {
        return dataFabricatiei;
    }

    public void setDataFabricatiei(LocalDate dataFabricatiei) {
        this.dataFabricatiei = dataFabricatiei;
    }

    public int calculeazaVechime(){
        return LocalDate.now().getYear()-dataFabricatiei.getYear();
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "dataFabricatiei=" + dataFabricatiei +
                '}';
    }
}
