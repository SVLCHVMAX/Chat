package ru.simbirsoft.chat.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simbirsoft.chat.model.Message;
import ru.simbirsoft.chat.repository.MessageRepository;
import ru.simbirsoft.chat.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findById(long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void deleteById(long id) {
        messageRepository.deleteById(id);
    }
}
