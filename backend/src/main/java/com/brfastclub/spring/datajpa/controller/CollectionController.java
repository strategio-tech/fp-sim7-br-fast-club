package com.brfastclub.spring.datajpa.controller;

import com.brfastclub.spring.datajpa.exception.ResourceNotFoundException;
import com.brfastclub.spring.datajpa.model.Collection;
import com.brfastclub.spring.datajpa.repository.CollectionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CollectionController {
    @Autowired
    CollectionRepository collectionRepository;

    @GetMapping("/collections/{userId}")
    public ResponseEntity<Collection> findByUserId(@PathVariable("userId") String userId){
        List<Collection> collections = collectionRepository.findByUserId(userId);

        if(collections.isEmpty()){
            throw new ResourceNotFoundException("Not found collection with userId" + userId + ", whyyyyy?");
        }

        return new ResponseEntity<>(collections.get(0), HttpStatus.OK);
    }

    @PostMapping("/collections")
    public ResponseEntity<Collection> createCollection(@RequestBody Collection collection){
        //create a collection for the user after registered
        String userId = collection.getUserId();
        List<Collection> collections = collectionRepository.findByUserId(userId);

        if(collections.isEmpty()){
            Collection _collection = collectionRepository.save(new Collection(userId));
            return new ResponseEntity<Collection>(_collection, HttpStatus.CREATED);
            // throw new ResourceNotFoundException("Not found collection with userId" + userId + ", whyyyyy?");
        }

        return new ResponseEntity<>(collections.get(0), HttpStatus.OK);

    }
}
