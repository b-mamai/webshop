package com.bohdan.webshop.service;

import com.bohdan.webshop.entity.Role;
import com.bohdan.webshop.entity.User;
import com.bohdan.webshop.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public boolean createUser(User user) {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            return false;
        }
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(user.getPassword());
        userRepo.save(user);
        return true;
    }
}
