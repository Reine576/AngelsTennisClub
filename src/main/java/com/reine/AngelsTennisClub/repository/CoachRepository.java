package com.reine.AngelsTennisClub.repository;

import com.reine.AngelsTennisClub.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {



    // Retrieves all Coach entities from the database and orders them by their firstName in ascending order.
    List<Coach> findAllByOrderByFirstNameAsc();


    /* Retrieves: list of coaches WHO DO NOT HAVE any bookings associated with them.(e.g. to assign them new tasks*/
    List<Coach> findByBookingsIsEmptyOrderByFirstNameAscLastNameAsc();

    /*  Retrieves coaches who have NO BOOKINGS SCHEDULED ON A GIVEN DATE.
  =>The LEFT JOIN ensures that all coaches are included, even if they don't have any bookings.
  =>The query ensures that only coaches with NO bookings at all (b.bookingTime IS NULL) OR with
  bookings on dates other than the specified date (DATE(b.bookingTime) != :date) are selected.
  => DATE(b.bookingTime) extracts the date part from the LocalDateTime field, assuming you want to compare
  dates only (ignoring time)
     */
    @Query("SELECT c FROM Coach c LEFT JOIN c.bookings b WHERE b.bookingTime IS NULL OR DATE(b.bookingTime) != :date ORDER BY c.firstName ASC, c.lastName ASC")
    List<Coach> findCoachesWithoutBookingsOnDate(@Param("date") LocalDate date);

    /*
    This query retrieves all coaches and orders them by the court names of their bookings.
    USE CASE:generate a report/display a list showing which coaches are active in which courts, the query
    without DISTINCT will give you the detailed breakdown, showing every court where a coach has a
    booking.
    If a coach has bookings at multiple courts, they will appear multiple times in the result, once for each court.*/
    @Query("SELECT c FROM Coach c INNER JOIN c.bookings b INNER JOIN b.court ct ORDER BY ct.courtName")
    List<Coach> findALLCoachesGroupByCourt();  //

    List<Coach> findAllByCertificationOrderByFirstNameAsc(String certificate);

    //Add Additional custom queries can be defined here if needed

     /*                                           DECIDED, NOT NEEDED NOW
    Coach findByFirstNameAndLastName(String firstName, String lastName);

     */
}
