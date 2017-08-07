package za.co.bbd.dto;

import za.co.bbd.util.PetStatus;

public class Pet {

    private long id;
    private String name;
    private String imageLocation;
    private PetStatus status;

    public Pet(long id, String name, String imageLocation, PetStatus status) {
        this.id = id;
        this.name = name;
        this.imageLocation = imageLocation;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public PetStatus getStatus() {
        return status;
    }

    public void setStatus(PetStatus status) {
        this.status = status;
    }
}
