package com.reine.AngelsTennisClub.controller;


import com.reine.AngelsTennisClub.model.Court;
import com.reine.AngelsTennisClub.service.CourtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/courts")
public class CourtController {

    private final CourtServiceImpl courtServiceImpl;

    @Autowired
    public CourtController(CourtServiceImpl courtServiceImpl){
        this.courtServiceImpl = courtServiceImpl;
    }


    @GetMapping
    public String listCourts(Model model) {
        List<Court> courts = courtServiceImpl.getAllCourts();
        model.addAttribute("courts", courts);
        return "manage_courts";
    }

    @GetMapping("/add")
    public String showAddCourtForm(Model model) {
        model.addAttribute("court", new Court());
        return "court_form";
    }

    @PostMapping("/add")
    public String addCourt(@ModelAttribute Court court) {
        courtServiceImpl.saveCourt(court);
        return "redirect:/admin/courts";
    }

  @GetMapping("/edit/{id}")
    public String showEditCourtForm(@PathVariable("id") int id, Model model) {
      Optional<Court> court = courtServiceImpl.getCourtById(id);
      if(court.isPresent()){
          model.addAttribute("court", court.get());
          return "court_form";
      }else{
          return "404";
      }
   }

    @PostMapping("/edit/{id}")
    public String updateCourt(@PathVariable("id") String name, @ModelAttribute Court court) {
        court.setCourtName(name);
        courtServiceImpl.saveCourt(court);
        return "redirect:/admin/courts";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourt(@PathVariable("id") int id) {
        courtServiceImpl.deleteCourtById(id);
        return "redirect:/admin/courts";
    }
}
