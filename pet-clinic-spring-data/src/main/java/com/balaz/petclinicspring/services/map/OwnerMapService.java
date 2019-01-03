package com.balaz.petclinicspring.services.map;

import com.balaz.petclinicspring.model.Owner;
import com.balaz.petclinicspring.model.Pet;
import com.balaz.petclinicspring.services.OwnerService;
import com.balaz.petclinicspring.services.PetService;
import com.balaz.petclinicspring.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet type is required!");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }
    }


    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deletedById(Long id) {
        super.deletedById(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
//        for (Owner owner : this.findAll()) {
//            if (owner.getLastName().equalsIgnoreCase(lastName)) {
//                return owner;
//            }
//        }
//        return null;
//    }
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
