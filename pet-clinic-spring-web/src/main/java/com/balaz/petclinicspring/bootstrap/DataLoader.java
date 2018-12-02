package com.balaz.petclinicspring.bootstrap;

import com.balaz.petclinicspring.model.Owner;
import com.balaz.petclinicspring.model.PetType;
import com.balaz.petclinicspring.model.Vet;
import com.balaz.petclinicspring.services.OwnerService;
import com.balaz.petclinicspring.services.PetTypeService;
import com.balaz.petclinicspring.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;

    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType= petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType= petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Samuel");
        owner2.setLastName("Lobotka");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Romualdo");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Breed");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}
