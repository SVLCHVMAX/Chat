package ru.simbirsoft.chat.service;

import ru.simbirsoft.chat.model.Message;
import ru.simbirsoft.chat.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room findById(long id);
    void save(Room room);
    void deleteById(long id);
}
