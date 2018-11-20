package com.balaz.petclinicspring.services;

import com.balaz.petclinicspring.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String LastName);
}
