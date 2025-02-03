package com.pfisoc.journalApp.repository;

import com.pfisoc.journalApp.entity.JournalEntry;
import com.pfisoc.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);

}
