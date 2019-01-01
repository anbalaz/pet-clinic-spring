package com.balaz.petclinicspring.repositories;

import com.balaz.petclinicspring.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
