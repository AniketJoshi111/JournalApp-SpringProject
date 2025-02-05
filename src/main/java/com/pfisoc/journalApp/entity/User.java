package com.pfisoc.journalApp.entity;
import lombok.*;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NotNull
    private  String userName;
    @NotNull
    private  String password;

    @DBRef  // this is acting like foreign key
    private List<JournalEntry> journalEntries = new ArrayList<>();
    private List<String> roles;


}
