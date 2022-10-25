package com.example.cms.model.repository;

import com.example.cms.model.entity.Classroom;
import com.example.cms.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, java.lang.String> {

    //List<Classroom> search(@Param("searchTerm") String searchTerm);

    //List<Classroom> findClassroom();
}
