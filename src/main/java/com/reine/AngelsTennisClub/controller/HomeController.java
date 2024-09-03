package com.reine.AngelsTennisClub.controller;

import com.reine.AngelsTennisClub.service.BookingServiceImpl;
import com.reine.AngelsTennisClub.service.CoachServiceImpl;
import com.reine.AngelsTennisClub.service.CourtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    BookingServiceImpl bookingServiceImpl;
    CoachServiceImpl coachServiceImpl;
    CourtServiceImpl courtServiceImpl;

    @Autowired
    public HomeController(BookingServiceImpl bookingServiceImpl, CoachServiceImpl coachServiceImpl, CourtServiceImpl courtServiceImpl){
        this.bookingServiceImpl= bookingServiceImpl;
        this.coachServiceImpl = coachServiceImpl;
        this.courtServiceImpl = courtServiceImpl;
    }

    @GetMapping("/")
    public String home(Model model){
        return "index";
    }


}
