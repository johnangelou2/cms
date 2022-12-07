package com.example.cms.controller;
import com.example.cms.controller.dto.ReportDto;
import com.example.cms.controller.exceptions.ReportNotFoundException;
import com.example.cms.model.entity.Report;
import com.example.cms.model.entity.Admin;
import com.example.cms.model.repository.AdminRepository;
import com.example.cms.model.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class ReportController {
    @Autowired
    private final ReportRepository repository;

    @Autowired
    private AdminRepository adminRepository;

    public ReportController(ReportRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/reports")
    List<Report> retrieveAllReports() {
        return repository.findAll();
    }

    @PostMapping("/reports")
    Report createReport(@RequestBody ReportDto reportDto) {
        Report newReport = new Report();
        //date, time, status, admin
        newReport.setReportId(reportDto.getReportId());
        newReport.setDate(reportDto.getDate());
        newReport.setTime(reportDto.getTime());
        newReport.setType(reportDto.getType());
        newReport.setDescription(reportDto.getDescription());
        newReport.setStatus(reportDto.getStatus());
        newReport.setAdminId(adminRepository.findById(reportDto.getAdminId()).orElseThrow(() -> new ReportNotFoundException(reportDto.getAdminId())));

        return repository.save(newReport);
    }

    @GetMapping("/reports/{id}")
    Report retrieveReport(@PathVariable("id") Long reportId) {
        return repository.findById(reportId)
         .orElseThrow(() -> new ReportNotFoundException(reportId));
    }
    @DeleteMapping("/reports/{id}")
    void deleteReport(@PathVariable("id") Long reportId) {
        repository.deleteById(reportId);
    }

    @GetMapping("/reports/search/{searchTerm}")
    List<Report> searchReport(@PathVariable("searchTerm") String searchString) {
        return repository.search(searchString);
    }
    @PutMapping("/reports/{id}")
    Report updateReport(@RequestBody ReportDto reportDto, @PathVariable("id") Long reportId) {
        Report temp = repository.findById(reportId).orElseThrow();
        return repository.findById(reportId)
                .map(report -> {
                    //date, time, desc, type, status, admin
                    if(reportDto.getDate() == null)
                        report.setDate(temp.getDate());
                    else
                        report.setDate(reportDto.getDate());
                    if(reportDto.getTime() == null)
                        report.setTime(temp.getTime());
                    else
                        report.setTime(reportDto.getTime());
                    if(reportDto.getDescription() == null)
                        report.setDescription(reportDto.getDescription());
                    else
                        report.setDescription(temp.getDescription());
                    if(reportDto.getType() == null)
                        report.setType(temp.getType());
                    else
                        report.setType(reportDto.getType());
                    if(reportDto.getStatus() == null)
                        report.setStatus(temp.getStatus());
                    else {
                        report.setStatus(reportDto.getStatus());}
                    return repository.save(report);
                })
                .orElseGet(() -> {
                    return this.createReport(reportDto);
                });
    }
}
