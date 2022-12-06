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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentTests {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Test Individual Get Functionality
    @Test
    void getStudents() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/students/1006722520"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(1006722520L, receivedJson.get("id").longValue());
        assertEquals("John", receivedJson.get("firstName").textValue());
        assertEquals("Angelou", receivedJson.get("lastName").textValue());

    }
    @Test
    void updateStudent() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(put("/students/1006722520"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(1006722520L, receivedJson.get("id").longValue());
        assertEquals("John", receivedJson.get("firstName").textValue());
        assertEquals("Angelou", receivedJson.get("lastName").textValue());

        receivedJson.put("firstName", "Sean");
        receivedJson.put("lastName", "ORourke");
        receivedJson.put("email", "sean@sean.org");

        assertTrue(studentRepository.findById(1006722520L).isPresent());
        Student testStu = studentRepository.findById(1006722520L).get();
        assertEquals("Sean", testStu.getFirstName());
        assertEquals("ORourke", testStu.getLastName());
        assertEquals("sean@sean.org", testStu.getEmail());
    }

    //Test creating a student
    @Test
    public void createStudent() throws Exception {
        ObjectNode studentJson = objectMapper.createObjectNode();
        studentJson.put("id", 1006722567);
        studentJson.put("firstName", "Sean");
        studentJson.put("lastName", "ORourke");
        studentJson.put("email", "sean@sean.org");

        MockHttpServletResponse response = mockMvc.perform(post("/students").
                        contentType("application/json").
                        content(studentJson.toString()))
                .andReturn().getResponse();
        assertEquals(200, response.getStatus());

        assertTrue(studentRepository.findById(1006722567L).isPresent());
        Student testStu = studentRepository.findById(1006722567L).get();
        assertEquals("Sean", testStu.getFirstName());
        assertEquals("ORourke", testStu.getLastName());
        assertEquals("sean@sean.org", testStu.getEmail());
    }

    @Test
    public void deleteStudent() throws Exception {
        //Create New Student to be Deleted
        Student s = new Student();
        s.setId(123456L);
        s.setFirstName("first");
        s.setLastName("last");
        s.setEmail("first@last.com");
        studentRepository.save(s);

        MockHttpServletResponse response = mockMvc.perform(
                        delete("/students/123456").
                                contentType("application/json"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(studentRepository.findById(123456L).isEmpty());
    }

    @Test
    public void testPasswordFunction() throws Exception{
        Student s = studentRepository.findById(1006722520L).get();

        MockHttpServletResponse response = mockMvc.perform(get("/students/1006722520"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);

        assertEquals("password123", receivedJson.get("password").textValue());

    }

    @Test
    void testStudentNotFound() throws Exception {
        Long id = 33445L;
        //Make sure no student exists with this Id
        assertTrue(studentRepository.findById(id).isEmpty());

        assertEquals((new StudentNotFoundException(id)).toString(), mockMvc.perform(get("/students/" + id))
                .andReturn().getResponse().getContentAsString());


    }

}
