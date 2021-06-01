package ru.simbirsoft.chat.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.simbirsoft.chat.model.Room;
import ru.simbirsoft.chat.repository.RoomRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoomServiceTest {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomService roomService;
    private Room room;

    @BeforeEach
    public void setUp() {
        room = new Room(0,"Room 1");
    }

    @AfterEach
    public void tearDown() {
        roomService.deleteById(room.getId());
        room = null;
    }

    @Test
    public void testSave() {
        roomService.save(room);
        Room fetchedRoom = roomService.findById(room.getId());

        assertEquals(room.getId(),fetchedRoom.getId());
    }

    @Test
    public void testFindAll() {
        roomService.save(room);
        List<Room> rooms = roomService.findAll();
        assertEquals("Room 1", rooms.get(0).getName());
    }

    @Test
    public void testFindById() {
        roomService.save(room);
        Room fetchedRoom = roomService.findById(room.getId());

        assertEquals(room.getName(),fetchedRoom.getName());
    }

    @Test
    public void testDeleteById() {
        roomService.save(room);
        Room room1 = new Room(0,"Room 2");
        roomService.save(room1);
        roomService.deleteById(room1.getId());
        assertThat(roomRepository.existsById(room1.getId())).isFalse();
    }
}
