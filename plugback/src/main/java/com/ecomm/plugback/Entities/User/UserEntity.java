package com.ecomm.plugback.Entities.User;

import jakarta.persistence.*;
import lombok.Data;

import com.ecomm.plugback.Enums.Role;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //set to auto so that the JPA picks right strategy
                                                    //according to the db used, we will be using mysql
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)      // the email should be unique
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
