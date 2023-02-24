package com.brfastclub.spring.datajpa.repository;

import com.brfastclub.spring.datajpa.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{

}
