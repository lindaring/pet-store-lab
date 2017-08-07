package za.co.bbd.service;

import org.springframework.stereotype.Service;
import za.co.bbd.dto.Pet;
import za.co.bbd.util.PetStatus;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init() {
        Pet bird = new Pet(1, "bird", "location/1.jpg", PetStatus.AVAILABLE);
        Pet cat = new Pet(2, "cat", "location/2.jpg", PetStatus.ORDERED);
        Pet dog = new Pet(3, "dog", "location/3.jpg", PetStatus.ORDERED);
        Pet rabbit = new Pet(4, "rabbit", "location/4.jpg", PetStatus.AVAILABLE);
        Pet snake = new Pet(5, "snake", "location/5.jpg", PetStatus.ORDERED);

        petList.add(bird);
        petList.add(cat);
        petList.add(dog);
        petList.add(rabbit);
        petList.add(snake);
    }

    public Pet findById(int id) {
        Optional<Pet> pet = petList.stream().filter(p -> p.getId() == id).findFirst().;
        return pet.isPresent() ? pet.get() : null;
    }

    public Pet findByStatus(PetStatus status) {
        Optional<Pet> pet = petList.stream().filter(p -> p.getStatus() == status).findFirst();
        return pet.isPresent() ? pet.get() : null;
    }

    public boolean addPet(Pet pet) {
        return petList.add(pet);
    }

    public boolean updatePet(int id, Pet pet) {
        Pet updatePet = findById(id);
        if (updatePet != null) {
            updatePet.setName(pet.getName());
            updatePet.setStatus(pet.getStatus());
            updatePet.setImageLocation(pet.getImageLocation());
            return true;
        } else {
            return false;
        }
    }

    public boolean uploadImage(int id, String url) {
        Pet pet = findById(id);
        if (pet != null) {
            pet.setImageLocation(url);
            return true;
        } else {
            return false;
        }
    }

    public List<Pet> getAllPets() {
        return petList;
    }

    public long getStatusNumber(PetStatus status) {
        return petList.stream().filter(p -> p.getStatus()== status).count();
    }

}
