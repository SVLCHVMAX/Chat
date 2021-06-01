package ru.simbirsoft.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.simbirsoft.chat.model.Role;
import ru.simbirsoft.chat.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/")
    public List<Role> listRole() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable("id") int id) {
        return roleService.findById(id);
    }

    @PostMapping("/")
    public Role addRole(@RequestBody Role role) {
        roleService.save(role);
        return role;
    }

    @PutMapping("/{id}")
    public Role updateRole(@RequestBody Role newRole, @PathVariable("id") int id) {
        Role role = roleService.findById(id);
        if (role != null) {
            role.setRoleType(newRole.getRoleType());
            roleService.save(role);
            return role;
        }
        else {
            newRole.setId(id);
            roleService.save(newRole);
            return newRole;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable("id") int id) {
        roleService.deleteById(id);
        return "Deleted role with id - " + id;
    }
}
