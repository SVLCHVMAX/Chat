package ru.simbirsoft.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.simbirsoft.chat.model.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
