package com.test.springtesting.repository;


import com.test.springtesting.model.entity.Pet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    List<Pet> findByBreed(String breed);
}