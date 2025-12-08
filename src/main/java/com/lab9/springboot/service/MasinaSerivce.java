package com.lab9.springboot.service;

import com.lab9.springboot.model.Masina;
import com.lab9.springboot.repository.MasinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class MasinaSerivce {

    @Autowired
    MasinaRepository masinaRepository;

    public Masina adaugaMasina(Masina m){
        return masinaRepository.save(m);
    }

    public boolean stergeMasina(String nr) {

        if (masinaRepository.existsById(nr)) {
            masinaRepository.deleteById(nr);
            return true;
        }

        return false;
    }

    public Masina cautaMasina(String nr){
        return masinaRepository.findById(nr).orElse(null);
    }

    public int nrMasiniDupaMarca( String marca){
        return masinaRepository.countByMarca(marca);
    }

}
