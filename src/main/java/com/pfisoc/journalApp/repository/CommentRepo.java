package com.pfisoc.journalApp.repository;

import com.pfisoc.journalApp.entity.Comment;
import com.pfisoc.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepo extends MongoRepository<Comment, ObjectId> {

}
