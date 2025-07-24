package com.example.uberprojectentity.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car extends BaseModel {
    @Column(unique = true)
    private String platNumber;

    private String brand;

    private String model;


    @Enumerated(EnumType.STRING)
    private CarType carType;

    @OneToOne(cascade = CascadeType.ALL)
    private Driver driver;

    @ManyToOne
    private Color color;

}
