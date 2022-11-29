package com.example.cms;

import com.example.cms.model.entity.Room;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoomRepoTests {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Doesnt work yet
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
    void addRoom() throws Exception{

    }
}
