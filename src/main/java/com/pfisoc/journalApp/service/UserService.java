package com.pfisoc.journalApp.service;


import com.pfisoc.journalApp.entity.JournalEntry;
import com.pfisoc.journalApp.entity.User;
import com.pfisoc.journalApp.repository.JournalEntryRepo;
import com.pfisoc.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private  static  final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepo.save(user);
    }
    public void saveNewUser(User user)
    {
        userRepo.save(user);
    }


    public Optional<User> findById(ObjectId id)
    {
        return userRepo.findById(id);
    }

    public void deleteUserById(ObjectId id)
    {
        userRepo.deleteById(id);
        return ;
    }

    public  User findByUserName(String userName)
    {
        return userRepo.findByUserName(userName);
    }
}
