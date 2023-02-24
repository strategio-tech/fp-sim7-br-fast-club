package com.brfastclub.spring.datajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

    @ManyToOne
    private Restaurant restaurant;

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "review")
	private String review;

    @Column(name = "reviewer")
	private String reviewer;


    public Review() {
    }

    public Review(long id, String review, String reviewer) {
        this.review = review;
        this.reviewer = reviewer;
    }

    public String getReview() {
        return this.review;
    }

    // public void setReview(String review) {
    //     this.review = review;
    // }

    public String getReviewer() {
        return this.reviewer;
    }

    // public void setReviewer(String reviewer) {
    //     this.reviewer = reviewer;
    // }

    public Restaurant getRestaurant(){
        return restaurant;
    }


}
