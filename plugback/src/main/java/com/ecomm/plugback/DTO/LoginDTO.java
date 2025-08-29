package com.ecomm.plugback.DTO;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.Valid;


@Data
@Valid
public class LoginDTO {
    @NotBlank
    @Email
    private String email;


    private String password;
}
