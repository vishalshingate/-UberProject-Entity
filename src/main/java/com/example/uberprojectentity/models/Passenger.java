package com.example.uberprojectentity.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","bookings"})
public class Passenger extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne
    private Booking activeBooking;

    @DecimalMin(value = "0.00", message = "Rating must be getter than 0.0 or equal to 5")
    @DecimalMax(value = "5.00", message = "Rating must be getter than 0.0 or equal to 5")
    private Double rating;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>();


}
