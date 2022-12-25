package com.test.GestionDesEtudiants.service;

import com.test.GestionDesEtudiants.models.Etudiant;
import com.test.GestionDesEtudiants.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/Etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @RequestMapping(value="/Index")
    public String Index(Model model, @RequestParam(name = "page",defaultValue = "0")int p){
        Page<Etudiant> pageEtudiants = etudiantRepository.findAll(PageRequest.of(  p,1));
        model.addAttribute("pageEtudiants", pageEtudiants);
        int pagescount =pageEtudiants.getTotalPages();
        int [] pages=new int[pagescount];
        for (int i=0;i<pagescount;i++) pages[i]=i;
        model.addAttribute("pages",pages);
        return "etudiants";
    }

}
