package com.reine.AngelsTennisClub.service;


import com.reine.AngelsTennisClub.model.Court;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public interface CourtService {

    Court addCourt(Court court);

    Optional<Court> findCourtByName(String courtName);

    List<Court> findALLCourtsOrderByCourtNameAsc();

    List<Court> findCourtsWithNoBooking();

    Map<Court, Long> countBookingsForCourts();


}
