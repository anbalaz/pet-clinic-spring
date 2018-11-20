package com.balaz.petclinicspring.services;

import com.balaz.petclinicspring.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String LastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
