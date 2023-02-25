package com.brfastclub.spring.datajpa.repository;

import com.brfastclub.spring.datajpa.model.Collection;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends CrudRepository<Collection, Long>{
    List<Collection> findByUserId(String userId);
}
