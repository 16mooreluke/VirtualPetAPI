package com.example.VirtualPetAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
    Map<String, VirtualPet> pets = new HashMap<>();

    public ArrayList<VirtualPet> getAllPets() {
        ArrayList<VirtualPet> petsInArray = new ArrayList<>(pets.values());
        return petsInArray;
    }

    private Map<String, VirtualPet> cages = new HashMap<>();

    public ArrayList<VirtualPet> getDogCageCleanliness() {
        ArrayList<VirtualPet> cagesInArrayList = new ArrayList<>(cages.values());
        return cagesInArrayList;
    }

    public VirtualPet getPet(String name) {
        return pets.get(name);
    }

    public void add(VirtualPet addNewPet) {
        pets.put(addNewPet.getName(), addNewPet);
    }

    public void Adopt(VirtualPet pet) {
        pets.remove(pet.getName(), pet);
    }

    public void feedAllPets() {
        System.out.println("Ok bringing out the food.");
        for (VirtualPet pet : pets.values()) {
            if (pet.getLifeType().equals("Organic")) {
                pet.feedAll();
            }
        }
    }
    public void waterAllPets() {
        System.out.println("Ok bringing out the water.");
        for (VirtualPet pet : pets.values()) {
            if (pet.getLifeType().equals("Organic")) {
                pet.waterAll();
            }
        }
    }

    public void playWithAPet(String name) {
        VirtualPet playPet = new VirtualPet();
        playPet = pets.get(name);
        playPet.play();
    }

    public void walkAllDogs() {
        System.out.println("Oh no who said w-a-l-k");
        for (VirtualPet pet : pets.values()) {
            pet.walkAll();
        }
    }

    public void heal(String name) {
        VirtualPet healPet = new VirtualPet();
        healPet = pets.get(name);
        healPet.heal();
    }

    public void healAll() {
        System.out.println("Pills in rolled up cheese!");
        for (VirtualPet pet : pets.values()) {
            pet.healAll();
        }
    }

    public void oil(String name) {
        VirtualPet oilPet = new VirtualPet();
        oilPet = pets.get(name);
        oilPet.oil();
    }

    public void oilAll() {
        System.out.println("");
        for (VirtualPet pet : pets.values()) {
            if (pet.getLifeType().equals("Robotic")) {
                pet.oilAll();
            }

        }
    }

    public void cleanDogCages() {
        System.out.println("Which dog's cage would you like to clean?");
        for (VirtualPet pet : pets.values()) {
            pet.cleanDogCages();
        }
    }

    public void cleanLitterBox() {
        System.out.println("Yuck! Good thing its only virtual...");
        for (VirtualPet pet : pets.values()) {
            pet.cleanLitterBox();
        }
    }

    public void showPetNamesAndStats() {
        System.out.println("Name      Description                    Hunger  Happiness  Energy  Thirst  Health");
        for (VirtualPet pet : pets.values()) {
            System.out.println((addWhiteSpace(pet.getName(), 10)) + (addWhiteSpace(pet.getDescription(), 35))
                    + (addWhiteSpace(pet.getHunger(), 8)) + (addWhiteSpace(pet.getHappiness(), 8))
                    + (addWhiteSpace(pet.getEnergy(), 8)) + (addWhiteSpace(pet.getThirst(), 8))
                    + (addWhiteSpace(pet.getHealth(), 8)));

        }
    }

    public void showPetNamesAndDescriptions() {
        for (VirtualPet pet : pets.values()) {
            System.out.println(" " + addWhiteSpace(pet.getName(), 10) + " " + pet.getDescription());
        }
    }

    public static String addWhiteSpace(String inputStr, int wholeSpace) {
        String outputStr = "";
        outputStr = inputStr + " ".repeat(wholeSpace - inputStr.length());
        return outputStr;
    }

    public static String addWhiteSpace(int inputInt, int wholeSpace) {
        String outputStr = "";
        String inputStr = String.valueOf(inputInt);
        outputStr = inputStr + " ".repeat(wholeSpace - inputStr.length());
        return outputStr;
    }
}