package com.maxwell.youchat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maxwell.youchat.pojo.ChatMessage;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
@ServerEndpoint("/message")
public class WebSocketServiceImpl {

    private static CopyOnWriteArraySet<WebSocketServiceImpl> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        System.out.println("INFO::连接成功::" + this.toString());

    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // 将收到的消息发送回客户端
        ChatMessage receiveMessage = JSONObject.parseObject(message, ChatMessage.class);
        String content = receiveMessage.getContent();
        ChatMessage sendMessage = new ChatMessage(null, 1L, 0L, null, new Date().getTime(), content);
        try {
            sendMessage(sendMessage.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
