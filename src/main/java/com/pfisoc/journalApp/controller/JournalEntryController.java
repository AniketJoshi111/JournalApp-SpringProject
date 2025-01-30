package com.pfisoc.journalApp.controller;

import com.pfisoc.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry)
    {
        journalEntries.put(myEntry.getId() ,myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalById(@PathVariable Long id)
    {
        return journalEntries.get(id);
    }

    @DeleteMapping("id/{myId}")
    public  JournalEntry deleteJournalById(@PathVariable Long id)
    {
        return journalEntries.remove(id);
    }

    @PutMapping("id/{myId}")
    public  JournalEntry updateJournalById(@PathVariable Long id , @RequestBody JournalEntry entry)
    {
        return journalEntries.put(id,entry);

    }
}

