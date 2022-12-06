package com.example.cms;

import com.example.cms.model.entity.Student;
import com.example.cms.model.entity.Report;
import com.example.cms.model.repository.StudentRepository;
import com.example.cms.model.repository.ReportRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class ReportTests {
    @Autowired
    ReportRepository reportRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void testGetReport() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/reports/001"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(001L, receivedJson.get("reportId").longValue());
        assertEquals("2022-09-10", receivedJson.get("date").textValue());

    }
    @Test
    void testPutReport() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(put("/reports/001"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(001L, receivedJson.get("reportId").longValue());
        assertEquals("2022-09-10", receivedJson.get("date").textValue());

        receivedJson.put("date", "2022-12-01");

        assertTrue(reportRepository.findById(001L).isPresent());
        Report testRep = reportRepository.findById(001L).get();
        assertEquals("2022-12-01", testRep.getDate());
    }

    //Test creating a student
    @Test
    public void testCreateReport() throws Exception {
        ObjectNode reportJson = objectMapper.createObjectNode();
        reportJson.put("reportId", 10L);
        reportJson.put("date", "2022-12-10");
        reportJson.put("author", 22222222L);
        reportJson.put("status", "current");

        MockHttpServletResponse response = mockMvc.perform(post("/reports").
                        contentType("application/json").content(reportJson.toString()))
                .andReturn().getResponse();
        assertEquals(200, response.getStatus());

        assertTrue(reportRepository.findById(10L).isPresent());
        Report testRep = reportRepository.findById(10L).get();
        assertEquals(10, testRep.getReportId());
        assertEquals("2022-12-10", testRep.getDate());
        assertEquals(22222222L, testRep.getAuthor().getId());
        assertEquals("current", testRep.getStatus());
    }

    @Test
    public void testDeleteReport() throws Exception {
        //Create New Student to be Deleted
        Report r = new Report();
        r.setReportId(100L);
        r.setDate("first");
        reportRepository.save(r);

        MockHttpServletResponse response = mockMvc.perform(
                        delete("/reports/100").
                                contentType("application/json"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(reportRepository.findById(100L).isEmpty());
    }
}
