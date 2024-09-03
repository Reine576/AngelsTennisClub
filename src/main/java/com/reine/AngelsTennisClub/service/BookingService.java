package com.reine.AngelsTennisClub.service;

import com.reine.AngelsTennisClub.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookingService {

    Booking createBooking(Booking booking);

    Optional<Booking> getBookingById(int id);

  /*  Booking getBookingByCoachId(int id);    */

    List<Booking> getAllBookingsGroupByCoach();

    List<Booking> getBookingByCourtId(int id);

    List<Booking> getAllBookingsGroupByCourt();

    List<Booking> getAllBookings();

    /*             I WILL REMOVE OR GET THE CODE FOR THE CONDITION FIRST ex Can only update 3 days prior !
    Booking updateBooking(Booking booking);

     */


}
