package com.pfisoc.journalApp.service;

import com.pfisoc.journalApp.entity.Comment;
import com.pfisoc.journalApp.entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {

    @Autowired
    private Comment comment;

    @Autowired
    private JournalEntry journalEntry;



}
