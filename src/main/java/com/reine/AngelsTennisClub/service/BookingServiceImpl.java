package com.reine.AngelsTennisClub.service;


import com.reine.AngelsTennisClub.exceptions.ResourceNotFoundException;
import com.reine.AngelsTennisClub.model.Booking;
import com.reine.AngelsTennisClub.model.Coach;
import com.reine.AngelsTennisClub.repository.BookingRepository;
import com.reine.AngelsTennisClub.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final CoachRepository coachRepository;

    @Autowired  //This is CONSTRUCTOR based Dependency Injection
    public BookingServiceImpl(BookingRepository bookingRepository, CoachRepository coachRepository) {
        this.bookingRepository = bookingRepository;
        this.coachRepository = coachRepository;
    }



    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id); // CONSIDER: 'Optional.get()' without 'isPresent()' check
    }

    /*
    @Override
    public Booking getBookingByCoachId(int id) {
        return (Booking) bookingRepository.findByCoachCoachIDOrderByBookingTimeAsc(id);
    }
         */

    @Override
    public List<Booking> getAllBookingsGroupByCoach() {
        return bookingRepository.findAllGroupedByCoachOrderByBookingTimeASC();
    }

    @Override
    public List<Booking> getBookingByCourtId(int id) {
        return bookingRepository.findAllByCourtIdOrderByBookingTimeAsc(id);
    }

    @Override
    public List<Booking> getAllBookingsGroupByCourt() {
        return bookingRepository.findAllGroupedByCourtOrderByBookingTimeAsc();
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    /*  I INTEND RESTRICTING THIS FROM UPDATING OR GET THE CONDITION CODE FIRST
    @Override
    public Booking updateBooking(Booking booking) {
        return "";
    }
     */

    public void deleteBookingById(int id){
        bookingRepository.deleteById(id);
    }
}
