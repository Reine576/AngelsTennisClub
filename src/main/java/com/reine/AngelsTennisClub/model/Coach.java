package com.reine.AngelsTennisClub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="coaches")
public class Coach {

    @Id
    @Column(name="coach_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Required. Please fill")
    private String firstName; // Can this part AUTOFILL once Coach logs in ????

    private String lastName; // Can this part AUTOFILL once Coach logs in ????

    // Can we give options here?
    private String certification;  // I am not sure this is useful here


    /*
    // Bi-directionl ManyToMany
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(name = "coach_court",
    joinColumns = @JoinColumn(name = "coach_coach_id", referencedColumnName = "coach_id"),
    inverseJoinColumns = @JoinColumn(name = "court_court_id", referencedColumnName = "court_id"))
    private Set<Court> court = new HashSet<>();
     */

    /* NOTE: Depending...,Consider EAGER FETCH => @OneToMany(fetch = FetchType.EAGER, mappedBy = "coach") */
    @OneToMany(mappedBy = "coach")  // "coach" is the variable mentioned in Booking Class. It must be same
    private Set<Booking> bookings = new HashSet<>();
}