package com.example.VirtualPetAPI;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetApiApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoice;

        VirtualPetShelter myShelter = new VirtualPetShelter();
        VirtualPet pet = new OrganicDog("Max", "Very playful", "Organic", "Dog", "Male");
        VirtualPet pet1 = new OrganicCat("Miley", "Loves fish sticks", "Organic", "Cat", "Female");
        VirtualPet pet2 = new RoboticCat("Winston", "A friendly robotic pet", "Robotic", "Cat", "Male");
        VirtualPet pet3 = new RoboticCat("Halle", "A friendly robotic pet", "Robotic", "Cat", "Female");
        VirtualPet pet4 = new RoboticDog("Yoskar", "A friendly robotic pet", "Robotic", "Dog", "Male");
        VirtualPet pet5 = new OrganicDog("Trisha", "Previous support dog", "Organic", "Dog", "Female");
        VirtualPet pet6 = new OrganicCat("Trombone", "Loves fish sticks", "Organic", "Cat", "Female");

        myShelter.add(pet);
        myShelter.add(pet1);
        myShelter.add(pet2);
        myShelter.add(pet3);
        myShelter.add(pet4);
        myShelter.add(pet5);
        myShelter.add(pet6);

        System.out.println("");
        System.out.println("Welcome to the Virtual Pet Shelter! Adopt a pet today!\n");
        System.out.println("Here are the pets we currently have:\n");
        
        do {
            myShelter.showPetNamesAndStats();
            System.out.println("");
            System.out.println("Litter box: " + pet.getLitterBoxCleanliness());
            System.out.println();
            System.out.println("What would you like to do next?");
            System.out.println("1. Feed the pets");
            System.out.println("2. Water the pets");
            System.out.println("3. Play with a pet");
            System.out.println("4. Adopt a pet");
            System.out.println("5. Admit a pet");
            System.out.println("6. Walk the dogs");
            System.out.println("7. Clean dog cage(s)");
            System.out.println("8. Clean litter box");
            System.out.println("9. Oil robotic pets");
            System.out.println("10. Give medicine to a pet");
            System.out.println("0. Leave the shelter");
            userChoice = input.nextLine();

            if (userChoice.equals("1")) {
                myShelter.feedAllPets();
                System.out.println("Every pet thanked you for feeding them.\n");
            } else if (userChoice.equals("2")) {
                myShelter.waterAllPets();
                System.out.println("Every pet thanked you for watering them.\n");
            } else if (userChoice.equals("3")) {
                System.out.println("You'd like to play with a pet, please choose one by typing their name:");
                myShelter.showPetNamesAndDescriptions();
                String petName = input.nextLine();
                myShelter.playWithAPet(petName);
            } else if (userChoice.equals("4")) {
                System.out.println("You'd like to adopt a pet, please choose one by typing their name:\n");
                System.out.println("Here are the pets:\n");
                myShelter.showPetNamesAndDescriptions();

                String petToAdopt = input.nextLine();
                ArrayList<VirtualPet> petsInArray = myShelter.getAllPets();
                for (VirtualPet petName : petsInArray) {
                    if (petName.getName().equalsIgnoreCase(petToAdopt)) {
                        myShelter.Adopt(petName);
                    }
                }
                System.out.println("\nSuccessfully adopted: " + petToAdopt);

            } else if (userChoice.equals("5")) {
                System.out.println("You'd like to admit a pet. Please provide their name");
                String newPetName = input.nextLine();
                System.out.println("Please provide a brief description of " + newPetName);
                String newDescription = input.nextLine();
                System.out.println("Is " + newPetName + "organic or robotic?");
                String newLifeType = input.nextLine();
                System.out.println("What type of animal is " + newPetName + "?");
                String newAnimalType = input.nextLine();
                System.out.println("What gender is " + newPetName + "?");
                String newGender = input.nextLine();
                System.out.println("Rest easy, we'll take good care of " + newPetName + "!\n");
                if (newLifeType.toLowerCase().equals("organic")) {
                    if (newAnimalType.toLowerCase().equals("cat")) {
                        myShelter.add(new OrganicCat(newPetName, newDescription, newLifeType, newAnimalType, newGender));
                    } else if (newAnimalType.toLowerCase().equals("dog")) {
                        myShelter.add(new OrganicDog(newPetName, newDescription, newLifeType, newAnimalType, newGender));
                    } else {
                        System.out.println("Sorry, we currently cannot hold any other type of animal aside from cats and dogs.");
                    }
                } else if (newLifeType.toLowerCase().equals("robotic")) {
                    if (newAnimalType.toLowerCase().equals("cat")) {
                        myShelter.add(new RoboticCat(newPetName, newDescription, newLifeType, newAnimalType, newGender));
                    } else if (newAnimalType.toLowerCase().equals("dog")) {
                        myShelter.add(new RoboticDog(newPetName, newDescription, newLifeType, newAnimalType, newGender));
                    } else {
                        System.out.println("Sorry, we currently cannot hold any other type of animal aside from cats and dogs.");
                    }
                } else {
                    System.out.println("Sorry, we are only taking in animals that are either robotic or organic.");
                }
            } else if (userChoice.equals("6")) {
                myShelter.walkAllDogs();
                System.out.println("All dogs have been walked.");
            } else if (userChoice.equals("7")) {
                System.out.println("Which Dog's Cage would you like to clean?");
                for (VirtualPet petsVirtualPetsPet : myShelter.getAllPets()) {
                    System.out.println(petsVirtualPetsPet.getName());
                    input.nextLine();
                }
                System.out.println("No more little surprises...");
                myShelter.cleanDogCages();
            } else if (userChoice.equals("8")) {
                myShelter.cleanLitterBox();
                System.out.println("Next time, the cats can clean their own litter box.");
            } else if (userChoice.equals("9")) {
                myShelter.oilAll();
            } else if (userChoice.equals("10")) {
                System.out.println("You'd like to tend to a pet, please choose one by typing their name:");
                myShelter.showPetNamesAndDescriptions();
                String petName = input.nextLine();
                myShelter.heal(petName);
            }
            for (VirtualPet vp : myShelter.getAllPets()) {
                vp.tick();
                vp.check();
            }

        } while (!userChoice.equals("0"));
        System.out.println("Thanks for stopping by. Take care!");
        input.close();
    }
}