package com.gpcode.jwt.Service;

import com.gpcode.jwt.Entity.Role;
import com.gpcode.jwt.Entity.User;
import com.gpcode.jwt.Repository.RoleRepo;
import com.gpcode.jwt.Repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User save(User user) {
        log.info("Saving new user in database.");
        return userRepo.save(user);
    }

    @Override
    public Role save(Role role) {
        log.info("Saving new role [{}]in database.", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        log.info("Adding role [{}] to username [{}]!",roleName, username);
        user.getRoles().add(role);
    }

    @Override
    public User get(String username) {
        log.info("Fetching username [{}]!", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Fetching all users!");
        return userRepo.findAll();
    }
}
