package com.brfastclub.spring.datajpa.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {

	@OneToMany(mappedBy = "restaurant")
	private final List<Review> reviews = new ArrayList<>();

	@ManyToOne
	private Collection collection;

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "address")
	private String address;

    @Column(name = "city")
	private String city;

    @Column(name = "state")
	private String state;

    @Column(name = "country")
	private String country;

    @Column(name = "lat")
	private DecimalFormat lat;

    @Column(name = "lng")
	private DecimalFormat lng;

    @Column(name = "name")
	private String name;

    @Column(name = "suggester")
	private String suggester;

    @Column(name = "description")
	private String description;

	public Restaurant(){

	}

	public Restaurant(String address, String city, String state, String country, DecimalFormat lat, DecimalFormat lng, String name, String suggester, String description) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.lat = lat;
		this.lng = lng;
		this.name = name;
		this.suggester = suggester;
		this.description = description;
	}


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public DecimalFormat getLat() {
		return this.lat;
	}

	public void setLat(DecimalFormat lat) {
		this.lat = lat;
	}

	public DecimalFormat getLng() {
		return this.lng;
	}

	public void setLng(DecimalFormat lng) {
		this.lng = lng;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuggester() {
		return this.suggester;
	}

	public void setSuggester(String suggester) {
		this.suggester = suggester;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection getCollection(){
		return collection;
	}

	public List<Review> getReviews(){
		return reviews;
	}

}
