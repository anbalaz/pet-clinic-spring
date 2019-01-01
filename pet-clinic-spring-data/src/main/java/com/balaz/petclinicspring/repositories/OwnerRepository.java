package com.balaz.petclinicspring.repositories;

import com.balaz.petclinicspring.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
