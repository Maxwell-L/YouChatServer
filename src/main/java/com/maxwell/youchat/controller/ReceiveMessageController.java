package com.maxwell.youchat.controller;


import com.maxwell.youchat.pojo.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveMessageController {

    @PostMapping("/message")
    public void receiveMessage(Message message) {

    }
}