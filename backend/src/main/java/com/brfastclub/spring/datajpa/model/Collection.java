package com.brfastclub.spring.datajpa.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
// import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="collections")
public class Collection {

    // @OneToMany(mappedBy = "collection")
	// private final List<Restaurant> restaurants = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinTable(name = "collectionRestaurants",
        joinColumns = {@JoinColumn(name = "collectionId")},
        inverseJoinColumns = {@JoinColumn(name = "restaurantId")}
    )
    @JsonIgnore
    private Set<Restaurant> restaurants = new HashSet<>();

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @NotNull
    @Column(name = "userId")
	private String userId;

    public Collection() {
    }

    public Collection(String userId) {
        this.userId = userId;
    }

    public long getId(){
        return id;
    }

    public String getUserId() {
        return this.userId;
    }

    // public void setUserId(String userId) {
    //     this.userId = userId;
    // }

    public Set<Restaurant> getRestaurants(){
        return restaurants;
    }

    public void addRestaurant(Restaurant restaurant){
        this.restaurants.add(restaurant);
        restaurant.getCollections().add(this);
    }
}
