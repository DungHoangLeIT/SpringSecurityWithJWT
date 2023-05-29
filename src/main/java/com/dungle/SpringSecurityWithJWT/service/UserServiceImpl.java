package com.dungle.SpringSecurityWithJWT.service;

import com.dungle.SpringSecurityWithJWT.domain.Role;
import com.dungle.SpringSecurityWithJWT.domain.User;
import com.dungle.SpringSecurityWithJWT.repo.RoleRepo;
import com.dungle.SpringSecurityWithJWT.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleUser(String username, String rolename) {
        User user = userRepo.findByUsername(username).orElseThrow();
        Role role = roleRepo.findByname(rolename).orElseThrow();
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username).orElseThrow();
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
