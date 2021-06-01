package ru.simbirsoft.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.simbirsoft.chat.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
