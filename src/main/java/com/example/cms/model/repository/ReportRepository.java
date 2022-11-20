package com.example.cms.model.repository;

import com.example.cms.model.entity.Admin;
import com.example.cms.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(value = "select * from reports r " +
            "where lower(r.reportId) like lower(concat('%', :searchTerm, '%')) ", nativeQuery = true)
    List<Report> search(@Param("searchTerm") String searchTerm);
}
