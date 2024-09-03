package com.reine.AngelsTennisClub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.*;


@Data
@Entity
@Table(name="courts")
public class Court {
    @Id
    @Column(name = "court_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //@NotBlank(message = "Required. Please select")
    private String courtName;

    /* private String reservationDate;  // Should this be a String?  // Remove it to avoid confusion */
    /*    //ManyToMany  bidirecti
           private Set<Coach> coaches = new HashSet<>();       */

    @OneToMany(mappedBy = "court")   // <== "court" is the variable mentioned in Booking Class. It must be same
    private Set<Booking> bookings = new HashSet<>();
}




