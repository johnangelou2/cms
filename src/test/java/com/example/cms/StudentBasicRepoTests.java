package com.example.cms;

import com.example.cms.controller.exceptions.StudentNotFoundException;
import com.example.cms.model.entity.Student;
import com.example.cms.model.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentBasicRepoTests {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Test Individual Get Functionality
    @Test
    void testGetStudents() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/students/1006722520"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(1006722520L, receivedJson.get("id").longValue());
        assertEquals("John", receivedJson.get("firstName").textValue());
        assertEquals("Angelou", receivedJson.get("lastName").textValue());

    }

    //Test creating a student
    @Test
    public void testCreateFunctionality() throws Exception {
        ObjectNode studentJson = objectMapper.createObjectNode();
        studentJson.put("id", 1006722567);
        studentJson.put("firstName", "Sean");
        studentJson.put("lastName", "ORourke");
        studentJson.put("email", "sean@sean.org");

        MockHttpServletResponse response = mockMvc.perform(post("/students")).andReturn().getResponse();

    }

}
