package com.pfisoc.journalApp.controller;

import com.pfisoc.journalApp.entity.JournalEntry;
import com.pfisoc.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAllJournalEntry();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry)
    {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalById(@PathVariable ObjectId myId)
    {
        return journalEntryService.getJournalEntryById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public  boolean deleteJournalById(@PathVariable ObjectId myId)
    {
        journalEntryService.deleteJournalEntryById(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public  JournalEntry updateJournalById(@PathVariable ObjectId myId , @RequestBody JournalEntry newEntry)
    {
        JournalEntry old = journalEntryService.getJournalEntryById(myId).orElse(null);
        if (old!=null)
        {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle():old.getTitle());
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }

}

