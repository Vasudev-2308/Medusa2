package com.example.medusa1;

public class ResponseMessage {
    String textMessage;
    boolean isMe;

    public ResponseMessage(String textMessage,boolean isMe) {
        this.textMessage = textMessage;
        this.isMe=isMe;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public boolean getMe() {
        return isMe;
    }

    public void setMe(Boolean me) {
        isMe = me;
    }

    public boolean isMe() {
        return isMe;
    }
}
