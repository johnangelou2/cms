package com.example.cms.controller;

import com.example.cms.controller.exceptions.ResidenceNotFoundException;
import com.example.cms.model.entity.Admin;
import com.example.cms.model.entity.Residence;
import com.example.cms.model.repository.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ResidenceController {

    @Autowired
    private final ResidenceRepository repository;

    public ResidenceController(ResidenceRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping("/residences/{id}")
    void deleteRoom(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/residences")
    List<Residence> retrieveAllResidences() {
        return repository.findAll();
    }

    @PostMapping("/residences")
    Residence createRoom(@RequestBody Residence newRez) {
        return repository.save(newRez);
    }

    @GetMapping("/residences/{id}")
    Residence retrieveResidence(@PathVariable("id") Long rezID) {
        return repository.findById(rezID)
                .orElseThrow(() -> new ResidenceNotFoundException(rezID));
    }
    @PutMapping("/residences/{id}")
    Residence updateResidence(@RequestBody Residence newResidence, @PathVariable("id") Long residenceID) {
        return repository.findById(residenceID)
                .map(residence -> {
                    residence.setName(newResidence.getName());
                    residence.setAddress(newResidence.getAddress());
                    return repository.save(residence);
                })
                .orElseGet(() -> {
                    newResidence.setResId(residenceID);
                    return repository.save(newResidence);
                });
    }
}
