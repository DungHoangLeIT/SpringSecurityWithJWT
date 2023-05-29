package com.dungle.SpringSecurityWithJWT.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddRoleUserRequest {
    private String username;
    private String roleName;
}
