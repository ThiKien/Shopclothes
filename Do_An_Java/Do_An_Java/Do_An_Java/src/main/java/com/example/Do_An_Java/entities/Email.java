package com.example.Do_An_Java.entities;

public class Email {
    private String recipient;



    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String subject;
    private String content;
    public Email() {
        this.recipient = recipient;
        this.subject = subject;
        this.content = content;
    }
}
