package ru.simbirsoft.chat.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import ru.simbirsoft.chat.model.Role;
import ru.simbirsoft.chat.model.User;
import ru.simbirsoft.chat.repository.UserRepository;
import ru.simbirsoft.chat.service.Impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Autowired
    @InjectMocks
    private UserServiceImpl userService;
    private User user;
    private Role role;
    private List<User> users;

    @BeforeEach
    public void setUp() {
        users = new ArrayList<>();
        role = new Role(1,"USER");
        user = new User(1L,"Name","Username","Password",role);
        users.add(user);
    }

    @AfterEach
    public void tearDown() {
        user = null;
        role = null;
        users = null;
    }

    @Test
    public void testSave() {
        when(userRepository.save(any())).thenReturn(user);
        userService.save(user);
        verify(userRepository,times(1)).save(any());
    }

    @Test
    public void testFindAll() {
        userRepository.save(user);
        when(userRepository.findAll()).thenReturn(users);
        List<User> userList = userService.findAll();
        assertEquals(userList,users);
        verify(userRepository,times(1)).save(user);
        verify(userRepository,times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
        assertThat(userService.findById(user.getId())).isEqualTo(user);
    }

    @Test
    public void testDeleteById() {
        userService.deleteById(user.getId());
        verify(userRepository).deleteById(user.getId());
    }

}
