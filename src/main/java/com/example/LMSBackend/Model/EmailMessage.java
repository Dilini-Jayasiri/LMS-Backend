package com.example.LMSBackend.Model;

public class EmailMessage {
    private String[] toEmail;
    private String subject;
    private String body;

    public EmailMessage() {
    }

    public EmailMessage(String[] toEmail, String subject, String body) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
    }

    public String[] getToEmail() {
        return toEmail;
    }

    public void setToEmail(String[] toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
