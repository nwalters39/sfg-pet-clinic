package com.newsproutsmedia.sfgpetclinic.controllers;

import com.newsproutsmedia.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/vets", "vets.html"})
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/", "vets.html", "index.html", "index", ""})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";

    }

}
