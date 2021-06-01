package ru.simbirsoft.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.simbirsoft.chat.model.Room;
import ru.simbirsoft.chat.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/")
    public List<Room> listRooms() {
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") long id) {
        return roomService.findById(id);
    }

    @PostMapping("/")
    public Room addRoom(@RequestBody Room room) {
        roomService.save(room);
        return room;
    }

    @PutMapping("/{id}")
    public Room updateRoom(@RequestBody Room newRoom, @PathVariable("id") long id) {
        Room room = roomService.findById(id);
        if(room!=null) {
            room.setName(newRoom.getName());
            roomService.save(room);
            return room;
        }
        else {
            newRoom.setId(id);
            roomService.save(newRoom);
            return newRoom;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable("id") long id) {
        roomService.deleteById(id);
        return "Deleted room with id - " + id;
    }
}
