package com.lab10.booksapp.controller;

import com.lab10.booksapp.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarteWebController {

    private final CarteRepository carteRepository;

    @Autowired
    public CarteWebController(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    @GetMapping("/lista-carti")
    public String listaCarti(Model model) {
        String s = "Lista cartilor";

        model.addAttribute("str" , s);
        model.addAttribute("carti", carteRepository.findAll());

        return "lista-carti";
    }
}