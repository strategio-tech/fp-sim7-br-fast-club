package com.brfastclub.spring.datajpa.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Collection {

    @OneToMany(mappedBy = "collection")
	private final List<Restaurant> restaurants = new ArrayList<>();

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "userId")
	private String userId;


    public Collection() {
    }

    public Collection(long id, String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    // public void setUserId(String userId) {
    //     this.userId = userId;
    // }

    public List<Restaurant> getRestaurants(){
        return restaurants;
    }
}
