package com.example.uberprojectentity.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class NamedLocation extends BaseModel {
    @OneToOne
    private ExactLocation exactLocation;

    private String name;

    private String zipCode;

    private String Country;

    private String State;

}
