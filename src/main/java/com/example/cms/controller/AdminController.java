package com.example.cms.controller;

import com.example.cms.controller.exceptions.AdminNotFoundException;
import com.example.cms.model.entity.Admin;
import com.example.cms.model.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private final AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/admins")
    List<Admin> retrieveAllAdmins() {
        return repository.findAll();
    }

    @PostMapping("/admins")
    Admin createAdmin(@RequestBody Admin newAdmin) {
        return repository.save(newAdmin);
    }

    @GetMapping("/admins/{id}")
    Admin retrieveAdmin(@PathVariable("id") Long adminId) {
        return repository.findById(adminId)
                .orElseThrow(() -> new AdminNotFoundException(adminId));
    }
    @PutMapping("/admins/{id}")
    Admin updateAdmin(@RequestBody Admin newAdmin, @PathVariable("id") Long adminId) {
        return repository.findById(adminId)
                .map(admin -> {
                    admin.setFullName(newAdmin.getFullName());
                    return repository.save(admin);
                })
                .orElseGet(() -> {
                    newAdmin.setId(adminId);
                    return repository.save(newAdmin);
                });
    }

    
    @DeleteMapping("/admins/{id}")
    void deleteAdmin(@PathVariable("id") Long adminId) {
        repository.deleteById(adminId);
    }

    @GetMapping("/admins/search/{searchTerm}")
    List<Admin> searchAdmin(@PathVariable("searchTerm") String searchString) {
        return repository.search(searchString);
    }
}
