package com.pfisoc.journalApp.service;

import com.pfisoc.journalApp.entity.JournalEntry;
import com.pfisoc.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntry journalEntry)
    {
        journalEntryRepo.save(journalEntry);

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
