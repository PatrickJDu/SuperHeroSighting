package com.mthree.superhero.controllers;

import com.mthree.superhero.daos.PowersRepository;
import com.mthree.superhero.models.Superpower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PowerController {

    @Autowired
    PowersRepository powerRepo;

    @GetMapping("powers")
    public String getPowers(Model model){
        List<Superpower> powers = powerRepo.findAll();
        model.addAttribute("powers",powers);
        return "powers";
    }
    @PostMapping("addPower")
    public String addPower(HttpServletRequest request){
        String name = request.getParameter("powerName");
        Superpower sp = new Superpower();

        sp.setName(name);
        powerRepo.save(sp);

        return "redirect:/powers";
    }
    @GetMapping("deletePower")
    public String deletePower(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        powerRepo.deleteById(id);
        return "redirect:/powers";
    }
    @GetMapping("editPower")
    public String editPower(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Superpower sp = powerRepo.getOne(id);

        model.addAttribute("power",sp);
        return "editPower";
    }
    @PostMapping("editPower")
    public String performEditPower(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Superpower sp = powerRepo.getOne(id);

        sp.setName(request.getParameter("powerName"));
        powerRepo.save(sp);
        return "redirect:/powers";
    }
}
