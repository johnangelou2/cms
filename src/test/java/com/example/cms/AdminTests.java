package com.example.cms;

import com.example.cms.model.entity.Admin;
import com.example.cms.model.entity.Student;
import com.example.cms.model.repository.AdminRepository;
import com.example.cms.model.repository.RoomRepository;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class AdminTests {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Retreave an admin (testing login specfically)
    @Test
    void getAdmin() throws Exception{
        Admin testAdmin = newAdmin();
        MockHttpServletResponse response = mockMvc.perform(get("/admins/"+testAdmin.getId()))
                .andReturn().getResponse();
        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(testAdmin.getId(), receivedJson.get("id").longValue());
        assertEquals(testAdmin.getEmail(), receivedJson.get("email").textValue());
        assertEquals(testAdmin.getPassword(), receivedJson.get("password").textValue());
    }

    Admin newAdmin() throws Exception{
        ObjectNode adminJson = objectMapper.createObjectNode();
        adminJson.put("id", 45678L);
        adminJson.put("firstName", "first");
        adminJson.put("lastName", "last");
        adminJson.put("email", "username@testing.com");

        MockHttpServletResponse response = mockMvc.perform(
                        post("/admins").
                                contentType("application/json").
                                content(adminJson.toString()))
                .andReturn().getResponse();
        Admin addedAdmin = adminRepository.findById(45678L).get();
        return addedAdmin;
    }

    //Test adding an admin for 2 reasons. First, will test for an eventual add account feature
    //Second, will show that adding an admin works, which will help for future tests
    @Test
    void addAdmin() throws Exception{
        ObjectNode adminJson = objectMapper.createObjectNode();
        adminJson.put("id", 45678L);
        adminJson.put("firstName", "first");
        adminJson.put("lastName", "last");
        adminJson.put("email", "username@testing.com");

        MockHttpServletResponse response = mockMvc.perform(
                        post("/admins").
                                contentType("application/json").
                                content(adminJson.toString()))
                .andReturn().getResponse();

        // assert HTTP code of response is 200 OK
        assertEquals(200, response.getStatus());

        // Assert student with id 8888 exists in our repository and then get the student object
        assertTrue(adminRepository.findById(45678L).isPresent());
        assertNotNull(adminRepository.findById(45678L));
        Admin addedAdmin = adminRepository.findById(45678L).get();

        // Assert the details of the students are correct
        assertEquals(45678L, addedAdmin.getId());
        assertEquals("first", addedAdmin.getFirstName());
        assertEquals("last", addedAdmin.getLastName());
        assertEquals("username@testing.com", addedAdmin.getEmail());
    }
}
