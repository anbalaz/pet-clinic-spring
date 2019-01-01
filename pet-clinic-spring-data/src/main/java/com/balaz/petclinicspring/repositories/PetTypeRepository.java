package com.balaz.petclinicspring.repositories;

import com.balaz.petclinicspring.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
