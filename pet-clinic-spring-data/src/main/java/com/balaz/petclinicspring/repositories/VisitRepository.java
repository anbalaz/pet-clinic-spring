package com.balaz.petclinicspring.repositories;

import com.balaz.petclinicspring.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
