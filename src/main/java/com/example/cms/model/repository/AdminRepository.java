package com.example.cms.model.repository;

import com.example.cms.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(value = "select * from admins a " +
            "where lower(a.fullName) like lower(concat('%', :searchTerm, '%')) ", nativeQuery = true)
    List<Admin> search(@Param("searchTerm") String searchTerm);
}
