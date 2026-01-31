package com.test.springtesting.test;

import com.test.springtesting.model.entity.Pet;
import com.test.springtesting.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
public class PetTesting {

    @Autowired
    PetRepository petRepository;  // Removed 'static'

    @BeforeEach  // Changed from @BeforeAll
    void setUp() {  // Removed 'static'
        Pet pet1 = new Pet();
        pet1.setAge(3);
        pet1.setName("pet1");
        pet1.setBreed("Cat");
        pet1.setGender("M");

        Pet pet2 = new Pet();
        pet2.setAge(5);
        pet2.setName("pet2");
        pet2.setBreed("Dog");
        pet2.setGender("F");

        Pet pet3 = new Pet();
        pet3.setAge(4);
        pet3.setName("pet3");
        pet3.setBreed("Cat");
        pet3.setGender("M");

        Pet pet4 = new Pet();
        pet4.setAge(3);
        pet4.setName("pet4");
        pet4.setBreed("Goat");
        pet4.setGender("F");

        Pet pet5 = new Pet();
        pet5.setAge(3);
        pet5.setName("pet5");
        pet5.setBreed("Cat");
        pet5.setGender("M");

        Pet pet6 = new Pet();
        pet6.setAge(5);
        pet6.setName("pet6");
        pet6.setBreed("Goat");
        pet6.setGender("F");

        Pet pet7 = new Pet();
        pet7.setAge(4);
        pet7.setName("pet7");
        pet7.setBreed("Dog");
        pet7.setGender("M");

        Pet pet8 = new Pet();
        pet8.setAge(3);
        pet8.setName("pet8");
        pet8.setBreed("Goat");
        pet8.setGender("F");

        petRepository.saveAll(List.of(pet1, pet2, pet3, pet4, pet5, pet6, pet7, pet8));
    }

    @Test
    void testSave_Success() {
        Pet newPet = new Pet();
        newPet.setAge(3);
        newPet.setName("pet9");  // Consider changing to pet9 to avoid duplicate
        newPet.setBreed("Dog");
        newPet.setGender("F");

        Pet savedPet = petRepository.save(newPet);

        Assertions.assertNotNull(savedPet);
        Assertions.assertEquals(newPet.getName(), savedPet.getName());

        System.out.println();
    }

    @Test
    void testSearchByBreed_Success() {
        String breed = "Cat";
        int expected = 3;

        List<Pet> search = petRepository.findByBreed(breed);

        Assertions.assertEquals(expected, search.size());
    }
}