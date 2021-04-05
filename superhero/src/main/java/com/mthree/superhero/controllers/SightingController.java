package com.mthree.superhero.controllers;

import com.mthree.superhero.daos.LocationRepository;
import com.mthree.superhero.daos.SightingRepository;
import com.mthree.superhero.models.Location;
import com.mthree.superhero.models.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
public class SightingController {

    @Autowired
    SightingRepository sightingRepo;

    @Autowired
    LocationRepository locationRepo;

    @GetMapping("sightings")
    public String getSightings(Model model){
        List<Sighting> sightings = sightingRepo.findAll();
        model.addAttribute("sightings",sightings);

        return "sightings";
    }
    @PostMapping("addSighting")
    public String addSighting(HttpServletRequest request){
        String heroName = request.getParameter("sightingName");
        String locationName = request.getParameter("locationName");
        String locationDescription = request.getParameter("locationDescription");
        String locationAddress = request.getParameter("locationAddress");
        double latitude = Double.parseDouble(request.getParameter("locationLatitude"));
        double longitude = Double.parseDouble(request.getParameter("locationLongitude"));
        LocalDateTime now = LocalDateTime.now();

        Sighting sighting = new Sighting();
        Location location = new Location();

        sighting.setName(heroName);
        sighting.setDateSeen(now);

        location.setName(locationName);
        location.setDescription(locationDescription);
        location.setAddress(locationAddress);
        location.setLatitude(latitude);
        location.setLongitude(longitude);

        sighting.setLocation(location);

        locationRepo.save(location);
        sightingRepo.save(sighting);

        return "redirect:/sightings";
    }
    @GetMapping("deleteSighting")
    public String deleteSighting(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Sighting sighting = sightingRepo.getOne(id);
        locationRepo.deleteById(sighting.getLocation().getId());
        sightingRepo.deleteById(id);

        return "redirect:/sightings";
    }
    @GetMapping("editSighting")
    public String editSighting(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Sighting sighting = sightingRepo.getOne(id);

        model.addAttribute("sighting", sighting);
        return "editSighting";
    }
    @PostMapping("editSighting")
    public String performEditSighting(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Sighting sighting = sightingRepo.getOne(id);
        Location location = locationRepo.getOne(sighting.getLocation().getId());

        sighting.setName(request.getParameter("sightingName"));
        location.setName(request.getParameter("locationName"));
        location.setDescription(request.getParameter("locationDescription"));
        location.setAddress(request.getParameter("locationAddress"));
        location.setLatitude(Double.parseDouble(request.getParameter("locationLatitude")));
        location.setLongitude(Double.parseDouble(request.getParameter("locationLongitude")));

        locationRepo.save(location);
        sightingRepo.save(sighting);
        return "redirect:/sightings";
    }
}
