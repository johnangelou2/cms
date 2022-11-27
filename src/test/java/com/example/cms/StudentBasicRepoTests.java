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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    //Test Get Functionality
    @Test
    void testGetStudents() throws Exception{
        Student s = studentRepository.findById(1006722520L).orElseThrow(() -> new StudentNotFoundException(1006722520L));

        ObjectNode expectedJson = objectMapper.createObjectNode();
        expectedJson.put("firstName", "John");
        expectedJson.put("lastName", "Angelou");
        expectedJson.put("password", "password123");

        mockMvc.perform(get("/students/1006722520"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect((ResultMatcher) content().json(expectedJson.toString()));
    }


    @Test
    public void testCreateFunctionality() {


    }

}
