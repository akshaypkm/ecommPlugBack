package com.ecomm.plugback.DTO;

import com.ecomm.plugback.Enums.Role;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private Role role; 
}
