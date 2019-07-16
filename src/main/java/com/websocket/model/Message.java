package com.websocket.model;

import lombok.Data;

/**
 * 消息实体类
 */
@Data
public class Message {
    private String name;
    public Message() {
    }
    public Message(String name) {
        this.name = name;
    }
}