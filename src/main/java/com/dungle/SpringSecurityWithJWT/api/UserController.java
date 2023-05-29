package com.dungle.SpringSecurityWithJWT.api;

import com.dungle.SpringSecurityWithJWT.domain.Role;
import com.dungle.SpringSecurityWithJWT.domain.User;
import com.dungle.SpringSecurityWithJWT.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok().body(userService.getUsers());
    }


    @PostMapping("/users/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.ok().body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?>saveRole (@RequestBody AddRoleUserRequest addRoleUserRequest){
        userService.addRoleUser(addRoleUserRequest.getUsername(), addRoleUserRequest.getRoleName());
        return ResponseEntity.ok().build();
    }
}
