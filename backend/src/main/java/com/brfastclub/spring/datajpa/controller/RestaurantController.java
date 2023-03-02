package com.brfastclub.spring.datajpa.controller;

import com.brfastclub.spring.datajpa.exception.ResourceNotFoundException;
import com.brfastclub.spring.datajpa.repository.RestaurantRepository;
import com.brfastclub.spring.datajpa.repository.CollectionRepository;
import com.brfastclub.spring.datajpa.model.Restaurant;
import com.brfastclub.spring.datajpa.model.Collection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RestaurantController {
    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        List<Restaurant> restaurants = new ArrayList<Restaurant>();

        restaurantRepository.findAll().forEach(restaurants::add);

        // if(restaurants.isEmpty()){
        //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // }

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @PostMapping("/collections/{userId}/restaurants")
    public ResponseEntity<Restaurant> addRestaurantWithLoationId(@PathVariable(value = "userId") String userId, @RequestBody Restaurant restaurantRequest){
            System.out.print(restaurantRequest.getName());
            List<Collection> collections = collectionRepository.findByUserId(userId);

            if(collections.isEmpty()){
                throw new ResourceNotFoundException("Not found collection with userId" + userId + ", whyyyyy?");
            }
            Collection collection = collections.get(0);
            //findById returns an Optional type, and has the map method
            //if we dont use this, the map method will be invalid

            //if we've already have this restaurant, the frontend will send an Id here
            //if not, it would be 0L
            String locationId = restaurantRequest.getLocationId();
            List<Restaurant> _restaurants = restaurantRepository.findRestaurantsByLocationId(locationId);
            Restaurant restaurant;
            if(!_restaurants.isEmpty()){
                restaurant = _restaurants.get(0);
                collection.addRestaurant(restaurant);
                collectionRepository.save(collection);
                // return new ResponseEntity<>(_restaurant, HttpStatus.CREATED);
            }else{
                //and it's 0L which means we dont have such an restaurant in our database now
                //we create one
                collection.addRestaurant(restaurantRequest);
                restaurant = restaurantRepository.save(restaurantRequest);
            }




        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    // @GetMapping("/collections/{userId}/restaurants/{locationId}")
    // public ResponseEntity<Restaurant> checkRestaurantInCollection(
    //     @PathVariable(value = "userId") String userId,
    //     @PathVariable(value = "locationId") String locationId){
    //         List<Collection> collections = collectionRepository.findByUserId(userId);

    //         if(collections.isEmpty()){
    //             throw new ResourceNotFoundException("Not found collection with userId" + userId + ", whyyyyy?");
    //         }
    //         long collectionId = collections.get(0).getId();

    //         List<Restaurant> _restaurants = restaurantRepository.findRestaurantsByLocationId(locationId);

    //         for(Restaurant r: _restaurants){
    //             if(r.getLocationId().equals(locationId)){
    //                 return new ResponseEntity<>(restaurant, HttpStatus.);
    //             }
    //         }
    // }


    // @PostMapping("/collections/{userId}/restaurants")
    // public ResponseEntity<Restaurant> addRestaurant(@PathVariable(value = "userId") String userId, @RequestBody Restaurant restaurantRequest){
    //         List<Collection> collections = collectionRepository.findByUserId(userId);

    //         if(collections.isEmpty()){
    //             throw new ResourceNotFoundException("Not found collection with userId" + userId + ", whyyyyy?");
    //         }
    //         long collectionId = collections.get(0).getId();
    //         //findById returns an Optional type, and has the map method
    //         //if we dont use this, the map method will be invalid
    //         Restaurant restaurant = collectionRepository.findById(collectionId).map(collection -> {
    //         //if we've already have this restaurant, the frontend will send an Id here
    //         //if not, it would be 0L
    //         long restaurantId = restaurantRequest.getId();

    //         if(restaurantId != 0L){
    //             Restaurant _restaurant = restaurantRepository.findById(restaurantId)
    //                 .orElseThrow(() -> new ResourceNotFoundException("Not found Restaurant with id = " + restaurantId));
    //             collection.addRestaurant(_restaurant);
    //             collectionRepository.save(collection);
    //             return _restaurant;
    //         }

    //         //and it's 0L which means we dont have such an restaurant in our database now
    //         //we create one
    //         collection.addRestaurant(restaurantRequest);
    //         return restaurantRepository.save(restaurantRequest);
    //     }).orElseThrow(() -> new ResourceNotFoundException("not found collection with userId = " + userId));

    //     return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    // }

    @GetMapping("/collections/{userId}/restaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurantsByCollectionUserId(@PathVariable(value = "userId") String userId){
        List<Collection> collections = collectionRepository.findByUserId(userId);

        if(collections.isEmpty()){
            throw new ResourceNotFoundException("Not found collection with userId" + userId + ", whyyyyy?");
        }

        long collectionId = collections.get(0).getId();
        List<Restaurant> restaurants = restaurantRepository.findRestaurantsByCollectionsId(collectionId);

        if(restaurants.isEmpty()){
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
}
