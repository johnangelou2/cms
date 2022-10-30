package com.example.cms.controller;

//import com.example.cms.controller.exceptions.RoomNotFoundException;
import com.example.cms.model.entity.Admin;
import com.example.cms.model.entity.Student;
import com.example.cms.model.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private final AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }
   /* @GetMapping("/admins")
    List<Student> retrieveAllAdmins() {
        return repository.findAll();
    }

    @PostMapping("/admins")
    Student createAdmin(@RequestBody Admin newAdmin) {
        return repository.save(newAdmin);
    } */

    @GetMapping("/admins/{id}")
    Student retrieveAdmin(@PathVariable("id") Long adminId) {
        return repository.findById(adminId)
               // .orElseThrow(() -> new AdminNotFoundException(adminId));
    }
    @DeleteMapping("/admins/{id}")
    void deleteAdmin(@PathVariable("id") Long adminId) {
        repository.deleteById(adminId);
    }

   /* @GetMapping("/admins/search/{searchstring}")
    List<Student> searchStudent(@PathVariable("searchstring") String searchString) {
        return repository.search(searchString);
    } */
}
