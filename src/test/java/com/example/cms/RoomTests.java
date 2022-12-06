package com.example.cms;

import com.example.cms.model.entity.RoomKey;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class RoomTests {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testRoomKeyGet() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/rooms/101/01"))
                .andReturn().getResponse();
        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        RoomKey key = new RoomKey(101, 1L);
        assertEquals(key.getRoomN(), receivedJson.get("roomKey").get("roomN").intValue());
    }

    @Test
    void updateRoom() throws Exception{
        ObjectNode roomJson = objectMapper.createObjectNode();
        roomJson.put("roomN", 101);
        roomJson.put("residenceId", 1L);
        roomJson.put("roomType", "Triple");
        roomJson.put("roomCap", 3);

        MockHttpServletResponse response = mockMvc.perform(put("/rooms/101/1").
                        contentType("application/json").content(roomJson.toString())).
                andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        RoomKey key = new RoomKey(101, 1L);
        assertEquals(key.getRoomN(), receivedJson.get("roomKey").get("roomN").intValue());
        assertEquals(key.getResidenceId(), receivedJson.get("roomKey").get("residenceId").longValue());
        assertEquals("\"Triple\"", receivedJson.get("roomType").toString());
        assertEquals(3, receivedJson.get("capacity").intValue());
    }

    //Test Room Not Found Exception
    @Test
    void testRoomNotFoundEx() throws Exception {
        //create dummy room that DNE
        ObjectNode roomJson = objectMapper.createObjectNode();
        roomJson.put("roomN", 1000001);
        roomJson.put("residenceId", 100L);
        roomJson.put("roomType", "Triple");
        roomJson.put("roomCap", 3);

        MockHttpServletResponse response = mockMvc.perform(get("/rooms/1000001/100")).
                andReturn().getResponse();
        //test for 404 error
        assertEquals(404, response.getStatus());
    }


    //While not used on the website, this test is set up in a way to assist other tests, ie
    //We add a room here, then use that room for the other tests
    /**
    @Test
    void addRoom() throws Exception {
        ObjectNode roomJson = objectMapper.createObjectNode();
        roomJson.put("residenceId", 1L);
        roomJson.put("roomN", 1001);
        roomJson.put("roomType", "singe");
        roomJson.put("roomCap", 1);

        MockHttpServletResponse response = mockMvc.perform(post("/rooms").
                contentType("application/json").content(roomJson.toString())).
                andReturn().getResponse();

        assertEquals(200, response.getStatus());

        RoomKey key = new RoomKey(1001, 1L);
        assertTrue(roomRepository.findById(key).isPresent());
        Room room = roomRepository.findById(key).orElseThrow();

        assertEquals("single",room.getRoomType());
        assertEquals(1, room.getCapacity());
        assertEquals(1001, room.getRoomKey().getRoomN());
        assertEquals(1L, room.getRoomKey().getResidenceId());

    }**/
}
