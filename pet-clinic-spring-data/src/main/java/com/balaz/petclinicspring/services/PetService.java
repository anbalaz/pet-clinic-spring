package com.balaz.petclinicspring.services;

import com.balaz.petclinicspring.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
