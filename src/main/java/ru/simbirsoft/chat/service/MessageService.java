package ru.simbirsoft.chat.service;

import ru.simbirsoft.chat.model.Message;
import ru.simbirsoft.chat.model.User;

import java.util.List;

public interface MessageService {
    List<Message> findAll();
    Message findById(long id);
    void save(Message message);
    void deleteById(long id);
}
