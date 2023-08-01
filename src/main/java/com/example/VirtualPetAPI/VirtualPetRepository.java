package com.example.VirtualPetAPI;

import org.springframework.data.jpa.repository.JpaRepository;

interface VirtualPetRepository extends JpaRepository<VirtualPet, Long> {

}
