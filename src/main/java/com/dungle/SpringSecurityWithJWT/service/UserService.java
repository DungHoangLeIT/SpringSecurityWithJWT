package com.dungle.SpringSecurityWithJWT.service;

import com.dungle.SpringSecurityWithJWT.domain.Role;
import com.dungle.SpringSecurityWithJWT.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();

}
