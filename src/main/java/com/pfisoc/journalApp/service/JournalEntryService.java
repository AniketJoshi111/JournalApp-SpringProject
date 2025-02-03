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
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;
    @Autowired
    private UserService userService;


    public void saveEntry(JournalEntry journalEntry ,  String userName)
    {
        User user = userService.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepo.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveUser(user);
    }

    public List<JournalEntry> getAllJournalEntry() {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getJournalEntryById(ObjectId id)
    {
        return journalEntryRepo.findById(id);
    }

    public void deleteJournalEntryById(ObjectId id)
    {
        journalEntryRepo.deleteById(id);
        return ;
    }
}
