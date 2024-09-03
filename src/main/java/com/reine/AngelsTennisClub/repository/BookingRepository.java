package com.reine.AngelsTennisClub.repository;

import com.reine.AngelsTennisClub.model.Booking;
import com.reine.AngelsTennisClub.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Optional<Booking> findById(int id);  // Why use Optional ?????

   // List<Booking> findByCoachIdOrderByBookingTimeAsc(int id);  <== Renaming required bc of Coach id = id

    /* This gets list of ALL Bookings,GROUPED by Coach,ORDERED by bookingTime in ascending order.
     Spring Data JPA doesn't directly support GROUP BY in the repository method naming conventions,
     that is why I am using a Custom Query with @Query
     */
    @Query("SELECT b FROM Booking b ORDER BY b.coach.firstName, b.bookingTime ASC")
    List<Booking> findAllGroupedByCoachOrderByBookingTimeASC();

    List<Booking> findAllByCourtIdOrderByBookingTimeAsc(int id);  // For individual court

    List<Booking> findByCourtOrderByBookingTimeAsc(Court court);

    /*  This counts the bookings for a specific court.    */
    Long countByCourt(Court court);

    /* This gets list of ALL Bookings,GROUPED by court,ORDERED by bookingTime in ascending order.
     Spring Data JPA doesn't directly support GROUP BY in the repository method naming conventions,
     that is why I am using a Custom Query with @Query
     */
    @Query("SELECT b FROM Booking b ORDER BY b.court.courtName, b.bookingTime ASC")
    List<Booking> findAllGroupedByCourtOrderByBookingTimeAsc();

}
