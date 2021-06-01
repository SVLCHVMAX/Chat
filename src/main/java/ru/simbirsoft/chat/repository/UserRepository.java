package ru.simbirsoft.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.simbirsoft.chat.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
