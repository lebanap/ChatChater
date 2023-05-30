package com.example.chatchater;

public class Message {
    public static String SENT_BY_ME = "me";
    public static String SENT_BY_AI = "ai";

    public String message;
    public String sentBy;

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", sentBy='" + sentBy + '\'' +
                '}';
    }

    public Message(String message, String sentBy) {
        this.message = message;
        this.sentBy = sentBy;
    }

    public String getMessage() {
        return message;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSentBy(String sentBy) {
        if (sentBy.equals(SENT_BY_ME) || sentBy.equals(SENT_BY_AI)) {
            this.sentBy = sentBy;
        } else {
            throw new IllegalArgumentException("Invalid value for sentBy: " + sentBy);
        }
    }
}
