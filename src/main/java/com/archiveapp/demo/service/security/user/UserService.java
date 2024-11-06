package com.archiveapp.demo.service.security.user;

import com.archiveapp.demo.entity.ERole;
import com.archiveapp.demo.entity.Role;
import com.archiveapp.demo.entity.User;
import com.archiveapp.demo.models.UserDto;
import com.archiveapp.demo.repository.RoleRepository;
import com.archiveapp.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName(ERole.valueOf("ROLE_ADMIN"));
        if(role == null){
            role = addAdminRole();
        }
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(user);
    }

    private Role addAdminRole(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
