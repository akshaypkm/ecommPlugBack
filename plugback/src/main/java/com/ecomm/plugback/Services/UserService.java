package com.ecomm.plugback.Services;

import com.ecomm.plugback.Entities.User.UserEntity;
import com.ecomm.plugback.Repository.UserRepository;
import com.ecomm.plugback.DTO.UserDTO;
import com.ecomm.plugback.DTO.LoginDTO;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    
    
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;

    }

    public UserEntity postUser(UserDTO userDTO){
        UserEntity user = new UserEntity();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getRole());

        return userRepo.save(user);
    }

    public boolean loginUser(LoginDTO loginDTO){

        String email = loginDTO.getEmail();
        String rawPassword = loginDTO.getPassword();

        Optional<UserEntity> userOptional = userRepo.findByEmail(email);

        
        if(userOptional.isEmpty()){
                    return false;
            }

        String storedHash = userOptional.get().getPassword();
        
        return passwordEncoder.matches(rawPassword,storedHash);
        
    }

    public Optional<UserEntity> getUser(Long id){
        return userRepo.findById(id);
    }
}
