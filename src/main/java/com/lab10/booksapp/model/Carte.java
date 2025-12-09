package com.lab10.booksapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carti")
@NoArgsConstructor
public class Carte {
    @Id
    @Column(name="isbn")
    private String isbn;
    private String titlu;
    private String autor;

    public Carte(String isbn, String titlu, String autor) {
        this.isbn = isbn;
        this.titlu = titlu;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "isbn='" + isbn + '\'' +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
