package com.pengoled.service;

import com.pengoled.domain.Role;
import com.pengoled.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
    List<Role> getRoles();
}
