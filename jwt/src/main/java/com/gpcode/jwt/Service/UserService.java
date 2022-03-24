package com.gpcode.jwt.Service;

import com.gpcode.jwt.Entity.Role;
import com.gpcode.jwt.Entity.User;

import java.util.List;

public interface UserService {
    User save (User user);
    Role save (Role role);
    void addRoleToUser(String username, String roleName);
    User get (String username);
    List<User> getAllUsers();
}
