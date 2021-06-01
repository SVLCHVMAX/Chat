package ru.simbirsoft.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.simbirsoft.chat.model.Message;
import ru.simbirsoft.chat.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/")
    public List<Message> listMessages() {
        return messageService.findAll();
    }

    @GetMapping("/{id}")
    public Message getMessage(@PathVariable("id") long id) {
        return messageService.findById(id);
    }

    @PostMapping("/")
    public Message addMessage(@RequestBody Message message) {
        messageService.save(message);
        return message;
    }

    @PutMapping("/{id}")
    public Message updateMessage(@RequestBody Message newMessage, @PathVariable("id") long id) {
        Message message = messageService.findById(id);
        if (message != null) {
            message.setContent(newMessage.getContent());
            message.setUser(newMessage.getUser());
            message.setRoom(newMessage.getRoom());
            messageService.save(message);
            return message;
        } else {
            newMessage.setId(id);
            messageService.save(newMessage);
            return newMessage;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteMessage(@PathVariable("id") long id) {
        messageService.deleteById(id);
        return "Deleted message with id - " + id;
    }
}
