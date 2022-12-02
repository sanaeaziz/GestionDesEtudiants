package com.test.GestionDesEtudiants.service;

import com.test.GestionDesEtudiants.models.Etudiant;
import com.test.GestionDesEtudiants.repository.EtudiantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/Etudiant")
public class EtudiantController {
    private EtudiantRepository etudiantRepository;


    @RequestMapping(value="/Index")
    public String Index( Model model){
        List<Etudiant> etds = etudiantRepository.findAll();
        model.addAttribute("etudiants", etds);
        return "etudiants";
    }
}
