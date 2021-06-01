package ru.simbirsoft.chat.service;

import ru.simbirsoft.chat.model.Message;
import ru.simbirsoft.chat.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(int id);
    void save(Role role);
    void deleteById(int id);
}
