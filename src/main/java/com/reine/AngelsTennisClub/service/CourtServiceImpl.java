package com.reine.AngelsTennisClub.service;


import com.reine.AngelsTennisClub.model.Court;
import com.reine.AngelsTennisClub.repository.BookingRepository;
import com.reine.AngelsTennisClub.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class CourtServiceImpl implements CourtService{

    private final CourtRepository courtRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public CourtServiceImpl(CourtRepository courtRepository, BookingRepository bookingRepository){
        this.courtRepository = courtRepository;
        this.bookingRepository = bookingRepository;
    }


    @Override
    public Court addCourt(Court court) {
        return courtRepository.save(court);
    }

    @Override
    public Optional<Court> findCourtByName(String courtName) {
        return courtRepository.findByCourtName(courtName);
    }

    @Override
    public List<Court> findALLCourtsOrderByCourtNameAsc() {
        return courtRepository.findAllByOrderByCourtNameAsc();
    }

    @Override
    public List<Court> findCourtsWithNoBooking() {
        return courtRepository.findCourtsWithNoBookings();
    }

    @Override
    public Map<Court, Long> countBookingsForCourts() {
        List<Court> courts = courtRepository.findAll();  // Get all courts
        Map<Court, Long> courtBookingCounts = new HashMap<>();

        for (Court court: courts){
            Long bookingCount = bookingRepository.countByCourt(court); // Count bookings for each court
            courtBookingCounts.put(court,bookingCount);
        }
        return courtBookingCounts;
    }
    public void deleteCourtById(int id){
        courtRepository.deleteCourtById(id);
    }
    public List<Court> getAllCourts(){
        return courtRepository.findAll();
    }
    public void saveCourt(Court court){
        courtRepository.save(court);
    }
   public Optional<Court> getCourtById(int id){
       return courtRepository.findById(id);
    }

}
