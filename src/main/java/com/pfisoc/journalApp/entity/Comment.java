package com.pfisoc.journalApp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

public class Comment {

    @Id
    private ObjectId id;
    private  String content;
    private LocalDateTime timestamp;

    @DBRef
    private  JournalEntry journalEntry;
}
