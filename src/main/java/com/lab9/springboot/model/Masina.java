package com.lab9.springboot.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor //constructor cu toti parametrii
@Entity
@Data // genereaza getter setter si toString
@AllArgsConstructor // constructor fara parametrii
@Table(name="vehicule") // foloseste numele scris aici , in caz contrar foloseste numele clasei
public class Masina {

    @Id
    @Column(name="nr_inmatriculare")
    private String nrInmatriculare;
    private String marca;
    private int anFabricatie;
    private String culoare;
    private int km;

}
