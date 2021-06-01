package ru.simbirsoft.chat.service;

import ru.simbirsoft.chat.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    void save(User user);
    void deleteById(long id);
}
