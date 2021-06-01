package ru.simbirsoft.chat.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.simbirsoft.chat.model.Message;
import ru.simbirsoft.chat.model.Role;
import ru.simbirsoft.chat.model.Room;
import ru.simbirsoft.chat.model.User;
import ru.simbirsoft.chat.repository.MessageRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoleService roleService;
    private Message message;
    private User user;
    private Room room;
    private Role role;

    @BeforeEach
    public void setUp() {
        role = new Role(0, "USER");
        user = new User(0, "name", "username", "password", role);
        room = new Room(0, "room");
        message = new Message(0, "content", user, room);

        roleService.save(role);
        userService.save(user);
        roomService.save(room);
    }

    @AfterEach
    public void tearDown() {
        messageService.deleteById(message.getId());
        roomService.deleteById(room.getId());
        userService.deleteById(user.getId());
        roleService.deleteById(role.getId());
        message = null;
        room = null;
        user = null;
        role = null;
    }

    @Test
    public void testSave() {
        messageService.save(message);
        Message fetchMessage = messageService.findById(message.getId());

        assertEquals(message.getId(), fetchMessage.getId());
    }

    @Test
    public void testFindAll() {
        messageService.save(message);
        List<Message> messages = messageService.findAll();
        assertEquals("content",messages.get(0).getContent());
    }

    @Test
    public void testFindById() {
        messageService.save(message);
        Message fetchMessage = messageService.findById(message.getId());

        assertEquals(message.getContent(),fetchMessage.getContent());
    }

    @Test
    public void testDeleteById() {
        messageService.save(message);
        Message message1 = new Message(0,"content",user,room);
        messageService.save(message1);
        messageService.deleteById(message1.getId());
        assertThat(messageRepository.existsById(message1.getId())).isFalse();
    }

}
