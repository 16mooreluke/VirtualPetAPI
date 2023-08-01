package com.example.VirtualPetAPI;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class VirtualPetController {

  private final VirtualPetRepository repository;

  VirtualPetController(VirtualPetRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/virtualPet")
  List<VirtualPet> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/virtualPet")
  VirtualPet newVirtualPet(@RequestBody VirtualPet newVirtualPet) {
    return repository.save(newVirtualPet);
  }

  // Single item
  
  @GetMapping("/virtualPet/{id}")
  VirtualPet one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new VirtualPetNotFoundException(id));
  }

  @PutMapping("/virtualPet/{id}")
  VirtualPet replaceVirtualPet(@RequestBody VirtualPet newVirtualPet, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(virtualPet -> {
        virtualPet.setName(newVirtualPet.getName());
        virtualPet.setDescription(newVirtualPet.getDescription());
        virtualPet.setLifeType(newVirtualPet.getLifeType());
        virtualPet.setAnimalType(newVirtualPet.getAnimalType());
        virtualPet.setGender(newVirtualPet.getGender());
        return repository.save(virtualPet);
      })
      .orElseGet(() -> {
        newVirtualPet.setId(id);
        return repository.save(newVirtualPet);
      });
  }

  @DeleteMapping("/virtualPet/{id}")
  void deleteVirtualPet(@PathVariable Long id) {
    repository.deleteById(id);
  }
}