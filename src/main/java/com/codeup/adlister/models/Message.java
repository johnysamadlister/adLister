package com.codeup.adlister.models;

import java.sql.Date;

public class Message {
    private long id;
    private Date date;
    private long sender_id;
    private long recipient_id;
    private long ad_id;
    private String body;

    public Message(long id, Date date, long sender_id, long recipient_id, long message_id, String body) {
        this.id = id;
        this.date = date;
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
        this.ad_id = message_id;
        this.body = body;
    }

    public Message (Date date, long sender_id, long recipient_id, long ad_id, String body) {
        this.date = date;
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
        this.ad_id = ad_id;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public long getSender_id() {
        return sender_id;
    }

    public long getRecipient_id() {
        return recipient_id;
    }

    public long getAd_id() {
        return ad_id;
    }

    public String getBody() {
        return body;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSender_id(long sender_id) {
        this.sender_id = sender_id;
    }

    public void setRecipient_id(long recipient_id) {
        this.recipient_id = recipient_id;
    }

    public void setAd_id(long ad_id) {
        this.ad_id = ad_id;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
