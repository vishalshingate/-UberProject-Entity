package com.example.uberprojectentity.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","bookings"})
public class Driver extends BaseModel {

    private String name;
    @Column(nullable = false, unique = true)
    private String licenceNumber;

    private String phoneNumber;

    private String aadharcard;

    @OneToOne(mappedBy = "driver", cascade= CascadeType.ALL)
    private Car car;

    @Enumerated(EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private ExactLocation lastKnowLocation;

    private String activeCity;

    @OneToOne
    private ExactLocation home;


    @DecimalMin(value = "0.00", message = "Rating must be getter than 0.0 or equal to 5")
    @DecimalMax(value = "5.00", message = "Rating must be getter than 0.0 or equal to 5")
    private Double rating;

    private boolean isAvailable;

    @OneToMany(mappedBy ="driver", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings = new ArrayList<>();

}
