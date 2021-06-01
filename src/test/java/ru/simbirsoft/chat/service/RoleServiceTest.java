package ru.simbirsoft.chat.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import ru.simbirsoft.chat.model.Role;
import ru.simbirsoft.chat.repository.RoleRepository;
import ru.simbirsoft.chat.service.Impl.RoleServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @Autowired
    @InjectMocks
    private RoleServiceImpl roleService;
    private Role role;
    private List<Role> roles;

    @BeforeEach
    public void setUp() {
        roles = new ArrayList<>();
        role = new Role(1, "USER");
        roles.add(role);
    }

    @AfterEach
    public void tearDown() {
        role = null;
        roles = null;
    }

    @Test
    public void testSave() {
        when(roleRepository.save(any())).thenReturn(role);
        roleService.save(role);
        verify(roleRepository, times(1)).save(any());
    }

    @Test
    public void testFindAll() {
        roleRepository.save(role);
        when(roleRepository.findAll()).thenReturn(roles);
        List<Role> roleList = roleService.findAll();
        assertEquals(roleList, roles);
        verify(roleRepository, times(1)).save(role);
        verify(roleRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(roleRepository.findById(1)).thenReturn(Optional.ofNullable(role));
        assertThat(roleService.findById(role.getId())).isEqualTo(role);
    }

    @Test
    public void testDeleteById() {
        roleService.deleteById(role.getId());
        verify(roleRepository).deleteById(role.getId());
    }
}
