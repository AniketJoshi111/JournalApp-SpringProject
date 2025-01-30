package com.pfisoc.journalApp.entity;

public class JournalEntry {

    private Long id;
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
