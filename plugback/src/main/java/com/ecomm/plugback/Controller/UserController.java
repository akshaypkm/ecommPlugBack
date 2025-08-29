package com.ecomm.plugback.Controller;

import com.ecomm.plugback.Services.UserService;
import com.ecomm.plugback.Entities.User.UserEntity;
import com.ecomm.plugback.DTO.UserDTO;
import com.ecomm.plugback.DTO.LoginDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserEntity userRegister(@RequestBody UserDTO userDTO ){
            
            return userService.postUser(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@Valid @RequestBody LoginDTO loginDTO){
        boolean val = userService.loginUser(loginDTO);

        if(val){
            return  ResponseEntity.status(HttpStatus.OK).body("login successful");
        }
            
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login failed");
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id){

        Optional<UserEntity> userOptional = userService.getUser(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
