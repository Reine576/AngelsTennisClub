package com.reine.AngelsTennisClub.repository;

import com.reine.AngelsTennisClub.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CourtRepository extends JpaRepository<Court, Integer> {

    Optional<Court> findByCourtName(String courtName);

    void deleteCourtById(int id);

    /* This retrieves all courts, sorted alphabetically by their names.  */
    List<Court> findAllByOrderByCourtNameAsc();

    /* Retrieves courts that don't have any bookings.*/
    @Query("SELECT c FROM Court c WHERE c.bookings IS EMPTY")
    List<Court> findCourtsWithNoBookings();

    /* This method counts how many bookings each court has and returns the court name along with the count           */
    @Query("SELECT c.courtName, COUNT(b) FROM Court c LEFT JOIN c.bookings b GROUP BY c.courtName")
    List<Court> countBookingsForCourts();
}
