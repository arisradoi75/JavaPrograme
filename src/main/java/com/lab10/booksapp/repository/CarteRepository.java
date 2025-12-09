package com.lab10.booksapp.repository;

import com.lab10.booksapp.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteRepository extends JpaRepository<Carte, String> {

}
