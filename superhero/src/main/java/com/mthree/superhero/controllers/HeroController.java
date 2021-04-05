package com.mthree.superhero.controllers;

import com.mthree.superhero.daos.HeroRepository;
import com.mthree.superhero.daos.PowersRepository;
import com.mthree.superhero.models.Hero;
import com.mthree.superhero.models.Superpower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HeroController {

    @Autowired
    HeroRepository heroRepo;

    @Autowired
    PowersRepository powerRepo;

    @GetMapping("heros")
    public String displayHeros(Model model){
        List<Hero> heros = heroRepo.findAll();
        model.addAttribute("heros", heros);
        return "heros";
    }
    @PostMapping("addHero")
    public String addHero(HttpServletRequest request){
        String name = request.getParameter("heroName");
        String description = request.getParameter("heroDescription");
        String power = request.getParameter("heroPower");

        Hero hero = new Hero();
        Superpower sp = new Superpower();

        hero.setName(name);
        hero.setDescription(description);

        sp.setName(power);

        hero.setSuperpower(sp);

        heroRepo.save(hero);
        powerRepo.save(sp);

        return "redirect:/heros";
    }
    @GetMapping("deleteHero")
    public String deleteHero(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Hero hero = heroRepo.getOne(id);
        powerRepo.deleteById(hero.getSuperpower().getId());
        heroRepo.deleteById(id);

        return "redirect:/heros";
    }
    @GetMapping("editHero")
    public String editHero(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Hero hero = heroRepo.getOne(id);

        model.addAttribute("hero", hero);
        return "editHero";
    }
    @PostMapping("editHero")
    public String performEditHero(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Hero hero = heroRepo.getOne(id);

        hero.setName(request.getParameter("heroName"));
        hero.setDescription(request.getParameter("heroDescription"));

        Superpower sp = powerRepo.getOne(hero.getSuperpower().getId());
        sp.setName(request.getParameter("heroPower"));
        hero.setSuperpower(sp);

        powerRepo.save(sp);
        heroRepo.save(hero);
        return "redirect:/heros";
    }
}
