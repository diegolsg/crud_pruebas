package com.covinoc.crud.adapter.api.security.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserApp {
    private String username;
    private String email;
    private String password;
    private boolean disabled;
    private boolean locked;
    private List<UserRole> roles;
}
