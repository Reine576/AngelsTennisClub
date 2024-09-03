package com.reine.AngelsTennisClub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Booking {

    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "coach_booking_id", nullable = true)
    private Coach coach;    // Is there no need to use Collections here?

    @ManyToOne
    @JoinColumn(name = "court_booking_id", nullable = true)
    private Court court;     // Is there no need to use Collections here?

    @NotBlank(message = "Required. Please select")
    private LocalDateTime bookingTime;

    @Enumerated(EnumType.STRING) // This annotation ensures that the enum is stored as a String in the database
    private BookingStatus status;

    /*

    //@NotBlank(message = "Required. Please select")
    // Store the number of 30-minute intervals
    private int durationIntervals;  // 1 interval = 30 minutes// Is it possible to Make it increments of 30 minutes

    // Custom setter with validation logic
    public void setDurationIntervals(int durationIntervals) {
        if (durationIntervals <= 0 || durationIntervals % 1 != 0) {
            throw new IllegalArgumentException("Duration must be in increments of 30 minutes.");
        }
        this.durationIntervals = durationIntervals;
    }

    // Helper method to convert to minutes
    public int getDurationInMinutes() {
        return durationIntervals * 30;
    }


   */

}
