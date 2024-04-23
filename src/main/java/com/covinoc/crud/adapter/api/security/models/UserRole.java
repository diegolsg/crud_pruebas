package com.covinoc.crud.adapter.api.security.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserRole {

    private String username;
    private String Role;
    private Date grantedDate;

}
