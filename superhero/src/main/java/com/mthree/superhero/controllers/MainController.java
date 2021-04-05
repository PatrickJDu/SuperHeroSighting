package com.mthree.superhero.controllers;

import com.mthree.superhero.daos.SightingRepository;
import com.mthree.superhero.models.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    SightingRepository sightingRepo;

    @GetMapping("/")
    public String home(Model model){
        List<Sighting> sightings = sightingRepo.findAll();
        sightings.sort(Comparator.comparing(Sighting::getDateSeen));
        Collections.sort(sightings, Collections.reverseOrder());
        sightings = sightings.subList(0,10);
        model.addAttribute("sightings", sightings);
        return "Index";
    }

}
