package com.example.cms.controller;

import com.example.cms.controller.exceptions.StudentNotFoundException;
import com.example.cms.model.entity.Student;
import com.example.cms.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/students")
    List<Student> retrieveAllStudents() {
        return repository.findAll();
    }

    @PostMapping("/students")
    Student createStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    @GetMapping("/students/{id}")
    Student retrieveStudent(@PathVariable("id") Long studentId) {
        return repository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    @PutMapping("/students/{id}")
    Student updateStudent(@RequestBody Student newStudent, @PathVariable("id") Long studentId) {
        Student temp = repository.findById(studentId).orElseThrow();
        return repository.findById(studentId)
                .map(student -> {
                    if (newStudent.getDateOfBirth().equals(null))
                        student.setDateOfBirth(temp.getDateOfBirth());
                    else
                        student.setDateOfBirth(newStudent.getDateOfBirth());
                    if (newStudent.getLastName().equals(null))
                        student.setLastName(temp.getLastName());
                    else
                        student.setLastName(newStudent.getLastName());
                    if (newStudent.getEmail().equals(null))
                        student.setEmail(temp.getEmail());
                    else
                        student.setEmail(newStudent.getEmail());
                    if (newStudent.getFirstName().equals(null))
                        student.setFirstName(temp.getFirstName());
                    else
                        student.setFirstName(newStudent.getFirstName());
                    return repository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(studentId);
                    return repository.save(newStudent);
                });
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable("id") Long studentId) {
        repository.deleteById(studentId);
    }

    @GetMapping("/students/search/{searchstring}")
    List<Student> searchStudent(@PathVariable("searchstring") String searchString) {
        return repository.search(searchString);
    }

}
