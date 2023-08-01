package com.example.VirtualPetAPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class VirtualPet {

    protected @Id @GeneratedValue Long id;
    protected String name;
    protected String description;
    protected int hunger;
    protected int thirst;
    protected int energy;
    protected int happiness;
    protected int health;
    protected String lifeType;
    protected String animalType;
    protected int dogCage;
    protected int litterBox;
    protected String gender;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLifeType(String lifeType) {
        this.lifeType = lifeType;
    }
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHealth() {
        return health;
    }

    public String getAnimalType() {
        return animalType;
    }

    public int getDogCageCleanliness() {
        return dogCage;
    }

    public int getLitterBoxCleanliness() {
        return litterBox;
    }

    public String getLifeType() {
        return lifeType;
    }

        public String getGender() {
        return gender;
    }

    public VirtualPet(String name, String description, String lifeType, String animalType, String gender) {
        this.name = name;
        this.description = description;
        this.lifeType = lifeType;
        this.hunger = 30;
        this.thirst = 30;
        this.energy = 90;
        this.happiness = 80;
        this.health = 100;
        this.animalType = animalType;
        this.litterBox = 100;
        this.dogCage = 100;
    }

    public VirtualPet() {

    }

    public void feed() {
        hunger -= 10;
        thirst += 5;
        energy += 5;
        happiness += 5;
        health += 5;
    }

    public void feedAll() {
        hunger -= 10;
        thirst += 5;
        energy += 5;
        happiness += 5;
        health += 5;
    }

    public void water() {
        thirst -= 10;
        hunger += 5;
        energy += 5;
        happiness += 5;
        health += 5;
    }

    public void waterAll() {
        thirst -= 10;
        hunger += 5;
        energy += 5;
        happiness += 5;
        health += 5;
    }

    public void play() {
        hunger += 5;
        thirst += 5;
        energy -= 10;
        happiness += 10;
        health += 5;
    }

    public void sleep() {
        hunger += 5;
        thirst += 5;
        energy += 10;
        happiness += 5;
    }

    public void walkAll() {
        hunger += 5;
        thirst += 10;
        energy -= 10;
        happiness += 10;
        health += 5;
        dogCage += 5;
    }

    public void oil() {
        health += 100;
        happiness += 20;
    }

    public void oilAll() {
        health += 100;
        happiness += 20;
    }

    public void heal() {
        health += 50;
        happiness += 20;
    }

    public void healAll() {
        health += 50;
        happiness += 20;
    }

    public void cleanDogCages() {
        health += 10;
        happiness += 10;
        dogCage += 100;
    }

    public void cleanLitterBox() {
        health += 10;
        happiness += 10;
        litterBox += 100;
    }

    public void check() {
        if (hunger > 85) {
            if (health > 0) {
                health -= 10;
            }
            System.out.println("  FEED ME");
        }

        if (thirst > 85) {
            if (health > 0) {
                health -= 10;
            }
            System.out.println("  I'm thirsty.");
        }

        if (energy < 15) {
            if (health > 0) {
                health -= 10;
            }
            System.out.println("  I need a nap.");
        }

        if (happiness < 15) {
            if (health > 0) {
                health -= 10;
            }
            System.out.println("  Can we go to the park?");
        }

        if (health < 65) {
            System.out.println("  Mr. Stark I don't feel so good");
        }

        if (dogCage < 60 && dogCage > 40) {
            System.out.println("  You live like this?");
        } else if (dogCage <= 40 && dogCage > 20) {
            System.out.println("  I think someone left a present for you...");
        } else if (dogCage <= 20) {
            if (health > 0) {
                health -= 10;
            }
            System.out.println("  People outside the shelter are beginning to complain.");
        }

        if (litterBox < 30) {
            if (health > 0) {
                health -= 10;
            }
            System.out.println("  You live like this?");
        }
    }

    public void tick() {
        hunger += 5;
        thirst += 5;
        energy -= 5;
        happiness -= 5;
        health -= 5;
        dogCage -= 5;
        litterBox -= 5;

        hunger = Math.min(100, Math.max(0, hunger));
        thirst = Math.min(100, Math.max(0, thirst));
        energy = Math.min(100, Math.max(0, energy));
        happiness = Math.min(100, Math.max(0, happiness));
        health = Math.min(100, Math.max(0, health));
        dogCage = Math.min(100, Math.max(0, dogCage));
        litterBox = Math.min(100, Math.max(0, litterBox));
    }
}