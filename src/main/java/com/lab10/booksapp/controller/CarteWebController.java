package com.lab10.booksapp.controller;

import com.lab10.booksapp.model.Carte;
import com.lab10.booksapp.repository.CarteRepository;
import com.lab10.booksapp.service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarteWebController {

    private CarteRepository carteRepository;
    private CarteService carteService;


    @Autowired
    public CarteWebController(CarteRepository carteRepository, CarteService carteService) {
        this.carteRepository = carteRepository;
        this.carteService = carteService;
    }

    @GetMapping("/lista-carti")
    public String listaCarti(Model model) {
        String s = "Lista cartilor";

        model.addAttribute("str" , s);
        model.addAttribute("carti", carteRepository.findAll());

        return "lista-carti";
    }

    @GetMapping("/adauga-carte")
    public String adaugaCarte(@RequestParam String isbn, @RequestParam String titlu, @RequestParam String autor ,Model model) {
        Carte carte = new Carte(isbn , titlu , autor);
        carteService.adaugaCarte(carte);
        model.addAttribute("mesaj", "Carte adaugata cu succes!");
        model.addAttribute("carti", carteRepository.findAll());

        return "lista-carti";
    }

    @GetMapping("/sterge-carte")
    public String stergeCarte(@RequestParam String isbn , Model model){
        boolean rezultat = carteService.stergeCarte(isbn);

        if(rezultat)
            model.addAttribute("mesaj", "Carte stearsa cu succes!");
        else
            model.addAttribute("mesaj", "Eroare la stergere!");

        model.addAttribute("carti", carteRepository.findAll());

        return "lista-carti";
    }
}