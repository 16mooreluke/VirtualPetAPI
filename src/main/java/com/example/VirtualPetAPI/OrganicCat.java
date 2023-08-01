package com.example.VirtualPetAPI;

public class OrganicCat extends OrganicPet {
    private String hairColor;
    public OrganicCat(String name, String description, String lifeType, String animalType, String gender) {
        super(name, description, lifeType, animalType, gender);
    }
    public OrganicCat(String name, String description, String lifeType, String animalType, String gender, String hairColor) {
        super(name, description, lifeType, animalType, gender);
        this.hairColor = hairColor;
    }
}
