package com.t3.visitoraccess.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.t3.visitoraccess.entity.User;
import com.t3.visitoraccess.entity.Visitor;
import com.t3.visitoraccess.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void createUser(User user) {
        user.setRoles("ROLE_USER");
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void addVisitor(String username, Visitor visitor){
        Optional<User> optUser = userRepository.findByUsername(username);

        if(optUser.isPresent()){
            User user = optUser.get();

            visitor.setResident(user);
            user.getMyVisitors().add(visitor);

            userRepository.save(user);
        }
        
    }
    
}
