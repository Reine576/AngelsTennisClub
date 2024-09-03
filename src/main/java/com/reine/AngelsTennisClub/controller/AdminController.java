package com.reine.AngelsTennisClub.controller;


import com.reine.AngelsTennisClub.model.Coach;
import com.reine.AngelsTennisClub.model.Court;
import com.reine.AngelsTennisClub.repository.CourtRepository;
import com.reine.AngelsTennisClub.service.CoachServiceImpl;
import com.reine.AngelsTennisClub.service.CourtServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AdminController {
    CourtRepository courtRepository;
    CoachServiceImpl coachServiceImpl;
    CourtServiceImpl courtServiceImpl;

    @Autowired
    public AdminController(CoachServiceImpl coachServiceImpl, CourtServiceImpl courtServiceImpl, CourtRepository courtRepository){
        this.coachServiceImpl = coachServiceImpl;
        this.courtServiceImpl = courtServiceImpl;
        this.courtRepository = courtRepository;
    }

    @GetMapping("/admin")
    public String getAdminHome(){
        return "admin_home";
    }



}
