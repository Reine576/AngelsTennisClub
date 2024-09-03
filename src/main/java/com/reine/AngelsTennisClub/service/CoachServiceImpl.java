package com.reine.AngelsTennisClub.service;


import com.reine.AngelsTennisClub.model.Coach;
import com.reine.AngelsTennisClub.repository.CoachRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;

    @Autowired
    public CoachServiceImpl(CoachRepository coachRepository){
        this.coachRepository=coachRepository;
    }


    @Override
    public Coach addCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public List<Coach> getALLCoachesOrderByFirstNameAsc() {
        return coachRepository.findAllByOrderByFirstNameAsc();
    }

    /*@Override             To Be developed Later!
    public Coach updateCoachInfo(Coach coach) {
        // Check if the coach ID is present
        if(coach.getId() == null){
            throw new IllegalArgumentException("Coach ID must not be null");
        }
        // Retrieve the existing coach from the database
        Coach existingCoach = coachRepository.findById(coach.getId())
                .orElseThrow(() -> new EntityNotFoundException("Coach not found with ID: " + coach.getId()));
        // Update the existing coach's details with the new values if provided
        // Handles updates properly, including cases where fields were previously unset (null).
        if (coach.getFirstName() != null) {
            existingCoach.setFirstName(coach.getFirstName());
        }
        if (coach.getLastName() != null) {
            existingCoach.setLastName(coach.getLastName());
        }
        if (coach.getCertification() != null) {
            existingCoach.setCertification(coach.getCertification());
        }

        // Save the updated coach back to the database
        return coachRepository.save(existingCoach);
    }*/

    @Override
    public void deleteCoachById(int id) {
        coachRepository.deleteById(id);

    }
}
