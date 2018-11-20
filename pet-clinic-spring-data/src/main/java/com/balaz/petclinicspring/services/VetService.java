package com.balaz.petclinicspring.services;

import com.balaz.petclinicspring.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
