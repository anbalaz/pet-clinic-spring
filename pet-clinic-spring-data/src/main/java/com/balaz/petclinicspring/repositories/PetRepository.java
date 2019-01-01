package com.balaz.petclinicspring.repositories;

import com.balaz.petclinicspring.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
