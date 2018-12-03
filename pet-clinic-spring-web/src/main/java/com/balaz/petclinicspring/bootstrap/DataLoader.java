package com.balaz.petclinicspring.bootstrap;

import com.balaz.petclinicspring.model.Owner;
import com.balaz.petclinicspring.model.Pet;
import com.balaz.petclinicspring.model.PetType;
import com.balaz.petclinicspring.model.Vet;
import com.balaz.petclinicspring.services.OwnerService;
import com.balaz.petclinicspring.services.PetTypeService;
import com.balaz.petclinicspring.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Second Street 15");
        owner1.setCity("Oklahoma");
        owner1.setTelephone("09453123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthday(LocalDate.now());
        mikesPet.setName("Rex");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Samuel");
        owner2.setLastName("Lobotka");
        owner2.setAddress("Beach Street 1");
        owner2.setCity("New York");
        owner2.setTelephone("0922321123");

        Pet samuelsPet = new Pet();
        samuelsPet.setPetType(saveCatPetType);
        samuelsPet.setOwner(owner2);
        samuelsPet.setBirthday(LocalDate.now());
        samuelsPet.setName("Fiona");
        owner2.getPets().add(samuelsPet);

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
