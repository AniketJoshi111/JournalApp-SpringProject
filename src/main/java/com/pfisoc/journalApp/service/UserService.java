package com.pfisoc.journalApp.service;


import com.pfisoc.journalApp.entity.JournalEntry;
import com.pfisoc.journalApp.entity.User;
import com.pfisoc.journalApp.repository.JournalEntryRepo;
import com.pfisoc.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void saveUser(User user)
    {
        userRepo.save(user);
    }



    public List<User> getAll() {
        return userRepo.findAll();
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
