package com.example.cms;

import com.example.cms.model.entity.Residence;
import com.example.cms.model.repository.ResidenceRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class ResidenceTests {
    //    private long resId;
    //    private String address;
    //    private String name;
    @Autowired
    ResidenceRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getRes() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/residences/1"))
                .andReturn().getResponse();
        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(1L, receivedJson.get("resId").longValue());
        assertEquals("78 Chestnut Road", receivedJson.get("address").textValue());
        assertEquals("Chestnut", receivedJson.get("name").textValue());
    }

    @Test
    void addRes() throws Exception {
        ObjectNode resJson = objectMapper.createObjectNode();
        resJson.put("resId", 20);
        resJson.put("address", "123FakeStreet");
        resJson.put("name", "fakeRes");

        MockHttpServletResponse response = mockMvc.perform(post("/residences").
                        contentType("application/json").content(resJson.toString())).
                andReturn().getResponse();

        assertEquals(200, response.getStatus());

        Residence addedRes = repository.findById(20L).orElseThrow();

        assertEquals(20, addedRes.getResId());
        assertEquals("123FakeStreet", addedRes.getAddress());
        assertEquals("fakeRes", addedRes.getName());
    }

    private Residence newResidenceGenerator() throws Exception{
        ObjectNode resJson = objectMapper.createObjectNode();
        resJson.put("resId", 20);
        resJson.put("address", "123FakeStreet");
        resJson.put("name", "fakeRes");

        MockHttpServletResponse response = mockMvc.perform(post("/residences").
                        contentType("application/json").content(resJson.toString())).
                andReturn().getResponse();
        Residence addedRes = repository.findById(20L).orElseThrow();
        return addedRes;
    }

    @Test
    void updateRes() throws Exception {
        Residence testedResidence = newResidenceGenerator();
        testedResidence.setAddress("newAddress");
        testedResidence.setName("newName");

        ObjectNode resJson = objectMapper.createObjectNode();
        resJson.put("resId", testedResidence.getResId());
        resJson.put("address", testedResidence.getAddress());
        resJson.put("name", testedResidence.getName());


        MockHttpServletResponse response = mockMvc.perform(put("/residences/"+ testedResidence.getResId()).
                        contentType("application/json").content(resJson.toString())).
                andReturn().getResponse();

        assertEquals(200, response.getStatus());

        Residence addedRes = repository.findById(testedResidence.getResId()).orElseThrow();
        assertEquals(addedRes.getResId(), testedResidence.getResId());
        assertEquals(addedRes.getAddress(), testedResidence.getAddress());
        assertEquals(addedRes.getName(), testedResidence.getName());
    }

    @Test
    void deleteRes() throws Exception {
        //First add dummy res
        Residence res = newResidenceGenerator();
        assertFalse(repository.findById(res.getResId()).isEmpty());

        MockHttpServletResponse response = mockMvc.perform(delete("/residences/"+ res.getResId()).
                        contentType("application/json")).
                andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(repository.findById(res.getResId()).isEmpty());
    }

}
