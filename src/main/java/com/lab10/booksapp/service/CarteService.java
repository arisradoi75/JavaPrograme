package com.lab10.booksapp.service;

import com.lab10.booksapp.model.Carte;
import com.lab10.booksapp.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteService {

    @Autowired
    CarteRepository carteRepository;
    public CarteService(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    public void adaugaCarte(Carte carte) {
        carteRepository.save(carte);
    }

    public boolean stergeCarte(String isbn){
        if(carteRepository.existsById(isbn)){
            carteRepository.deleteById(isbn);
            return true;
        }
        return false;
    }


}
