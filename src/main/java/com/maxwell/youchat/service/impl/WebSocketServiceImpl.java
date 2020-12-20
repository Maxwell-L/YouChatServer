package com.maxwell.youchat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maxwell.youchat.pojo.ChatMessage;
import com.maxwell.youchat.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Service
@ServerEndpoint(value = "/message/{userId}")
public class WebSocketServiceImpl {

    private static ConcurrentHashMap<Long, WebSocketServiceImpl> webSocketMap = new ConcurrentHashMap<>();
    private Session session;

    private Long id;
    private Long friendId;

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Long userId) {
        this.session = session;
        this.id = userId;
        webSocketMap.put(id, this);
        this.friendId = 1L ^ userId;
        System.out.println("INFO::连接成功::" + webSocketMap.size());
    }

    @OnClose
    public void onClose() {
        System.out.println("INFO::连接断开");
//        webSocketMap.remove(id);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // 将收到的消息发送回客户端
        ChatMessage receiveMessage = JSONObject.parseObject(message, ChatMessage.class);
        String content = receiveMessage.getContent();
        ChatMessage sendMessage = new ChatMessage(null, id, friendId, null, new Date().getTime(), content);
        try {
            while (webSocketMap.get(friendId) == null) {

            }
            sendMessage(webSocketMap.get(friendId), sendMessage.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    private void sendMessage(WebSocketServiceImpl service, String message) throws IOException {
        service.session.getBasicRemote().sendText(message);
    }

}
