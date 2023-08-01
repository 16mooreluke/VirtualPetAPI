package com.example.VirtualPetAPI;

class VirtualPetNotFoundException extends RuntimeException {

  VirtualPetNotFoundException(Long id) {
    super("Could not find Virtual Pet " + id);
  }
}