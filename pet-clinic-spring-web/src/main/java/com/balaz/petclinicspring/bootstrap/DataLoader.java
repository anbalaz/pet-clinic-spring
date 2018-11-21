package com.balaz.petclinicspring.bootstrap;

import com.balaz.petclinicspring.model.Owner;
import com.balaz.petclinicspring.model.Vet;
import com.balaz.petclinicspring.services.OwnerService;
import com.balaz.petclinicspring.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1= new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Samuel");
        owner2.setLastName("Lobotka");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");


        Vet vet1= new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Romualdo");

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setId(2L);
        vet2.setFirstName("John");
        vet2.setLastName("Breed");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");



    }
}
