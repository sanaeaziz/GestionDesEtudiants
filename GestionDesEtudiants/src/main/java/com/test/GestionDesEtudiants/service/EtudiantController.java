package com.test.GestionDesEtudiants.service;

import com.test.GestionDesEtudiants.models.Etudiant;
import com.test.GestionDesEtudiants.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Validated
@Controller
@RequestMapping(value = "/Etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @RequestMapping(value="/Index")
    public String Index(Model model,
                        @RequestParam(name = "page",defaultValue = "0")int p,
                        @RequestParam(name = "motCle",defaultValue ="")String mc){
        Page<Etudiant> pageEtudiants = etudiantRepository.searchEtudiants( "%"+mc+"%",PageRequest.of(p,3));

        int pagesCount =pageEtudiants.getTotalPages();
        int [] pages=new int[pagesCount];
        for (int i=0;i<pagesCount;i++) pages[i]=i;
        model.addAttribute("pages",pages);
        model.addAttribute("pageEtudiants",pageEtudiants);
        model.addAttribute("pageCount",p);
        model.addAttribute("motCle",mc);

        return "etudiants";
    }

    @RequestMapping(value = "/Form",method = RequestMethod.GET)
    public String FormEtudiants( Model model){
        model.addAttribute("etudiant",new Etudiant());//data binding

        return "formEtudiants";
    }
    @RequestMapping(value = "/SaveEtudiant",method = RequestMethod.POST)
    public String Save(@Valid Etudiant et, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "formEtudiants";
        }
        

            etudiantRepository.save(et);
        return "redirect:Index";
    }

}
