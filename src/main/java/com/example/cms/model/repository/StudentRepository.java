package com.example.cms.model.repository;

import com.example.cms.model.entity.Residence;
import com.example.cms.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //Find Students through name
    @Query(value = "select * from students s " +
            "where lower(s.firstName) like lower(concat('%', :searchTerm, '%')) or like lower(s.lastName) like lowerw(concat('%', :searchTerm, '%'))", nativeQuery = true)
    List<Student> search(@Param("searchTerm") String searchTerm);

    //Find Students through Residence
    @Query(value = "select * from students s " +
            "where residence.name = residences.name", nativeQuery = true)
    List<Student> searchByRes(@Param("residence") Residence residence);



    /**
    @Query(value = "select * from students s " +
            "where lower(s.initials) like lower(concat('%', :searchIni, '%'))", nativeQuery = true)
    List<Student> searchIn(@Param("searchIni") String searchIni);

    @Query(value = "select * from students where " +
            "id IN (SELECT s.id FROM STUDENTS s INNER JOIN MARKS m ON s.id = m.studentID " +
            "group by s.id HAVING AVG(Mark) >= 90)", nativeQuery = true)
    List<Student> findTopStudents();
     **/
}
