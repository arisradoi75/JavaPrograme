package com.lab9.springboot.controller;

import com.lab9.springboot.service.MasinaSerivce;
import org.springframework.ui.Model;;
import com.lab9.springboot.model.Masina;
import com.lab9.springboot.repository.MasinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MasinaWebController {

    @Autowired
    MasinaRepository masinaRepository;
    @Autowired
    private MasinaSerivce masinaSerivce;


    @GetMapping("/lista-masini")
    public String getListaMasini(Model model) {
        String s = "Lista masinilor preluate prin repository";
        model.addAttribute("str" , s);

        Iterable<Masina> lista = masinaRepository.findAll();
        model.addAttribute("masini", lista);

        return "lista-masini";
    }

    @PostMapping("/adauga-masina")
    public String adaugaMasina(@RequestParam String nrInmatriculare,
                               @RequestParam String marca,
                               @RequestParam int anFabricatie,
                               @RequestParam String culoare,
                               @RequestParam int km,
                               Model model){
        Masina masina = new Masina(nrInmatriculare,marca,anFabricatie,culoare,km);
        masinaSerivce.adaugaMasina(masina);

        model.addAttribute("mesaj" , "Masina a fost adaugata!");
        model.addAttribute("masini" ,masinaRepository.findAll());
        return "lista-masini";
    }

    @PostMapping("/sterge-masina")
    public String stergeMasina(@RequestParam String nrInmatriculare,
                                Model model) {
        boolean rezultat = masinaSerivce.stergeMasina(nrInmatriculare);

        if (rezultat)
            model.addAttribute("mesaj", "Mașina a fost ștearsă!");
        else
            model.addAttribute("mesaj", "Mașina NU există!");

        model.addAttribute("str", "Lista masinilor");
        model.addAttribute("masini", masinaRepository.findAll());

        return "lista-masini";
    }

    @PostMapping("/cauta-masina")
    public String cautaMasina(@RequestParam String nrInmatriculare,Model model){
        Masina masina = masinaSerivce.cautaMasina(nrInmatriculare);

        if(masina != null){
            model.addAttribute("masinaCautata",masina);
        }else {
            model.addAttribute("eroareCautare" , "Nu exista masina cu " + nrInmatriculare);
        }

        model.addAttribute("str", "Rezultatul cautarii");
        model.addAttribute("masini", masinaRepository.findAll());

        return "lista-masini";
    }

    @PostMapping("/numar-masini-marca")
    public String numarMasiniMarca(@RequestParam String marca,Model model){
        int rezultat = masinaSerivce.nrMasiniDupaMarca(marca);

        model.addAttribute("rezultatMarca",rezultat);
        model.addAttribute("marcaCautata" , marca);

        model.addAttribute("str" , "Cautarea masini dupa marca");
        model.addAttribute("masini" , masinaRepository.findAll());

        return "lista-masini";
    }

}
