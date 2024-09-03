package com.reine.AngelsTennisClub.service;


import com.reine.AngelsTennisClub.model.Coach;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoachService {

    Coach addCoach(Coach coach);

    List<Coach> getALLCoachesOrderByFirstNameAsc();

    //Coach updateCoachInfo(Coach coach);

    void deleteCoachById(int id); // QUESTION: What Happens if he already had bookings ????
}
