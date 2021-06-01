package ru.simbirsoft.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.simbirsoft.chat.model.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
