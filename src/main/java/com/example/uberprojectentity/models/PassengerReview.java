package com.example.uberprojectentity.models;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@PrimaryKeyJoinColumn(name= "passenger_review_id")
public class PassengerReview extends Review {

    private String PassengerReviewComment;

    private String PassengerRating;
}
