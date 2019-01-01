package com.balaz.petclinicspring.repositories;

import com.balaz.petclinicspring.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
