package com.chris.cheese.cheesemusic.web.server;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/chatSocket/{user}")
@Component
public class ChatWebSocketServer {
    private static int onlineCount = 1000000;

    private static CopyOnWriteArraySet<ChatWebSocketServer> chatWebSocketServers = new CopyOnWriteArraySet<>();

    private Session session;

    public Session getSession() {
        return session;
    }

    private String user = "";

    @OnOpen
    public void OnOpen(Session session, @PathParam("user") String user) {

        chatWebSocketServers.forEach(item -> {
            try {
                item.sendMessage("欢迎" + user + " 进入点歌台！" + "\uD83D\uDC0E");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        this.session = session;
        chatWebSocketServers.add(this);
        addOnlineCount();
        this.user = user;
    }

    @OnClose
    public void onClose() {
        chatWebSocketServers.remove(this);
        subOnlineCount();

        chatWebSocketServers.forEach(item -> {
            try {
                item.sendMessage(user + " 退出点歌台！" + "\uD83D\uDC0E");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        chatWebSocketServers.forEach(item -> {
            try {
                if (item.getSession().equals(session)) {
                    item.sendMessage("<b>我</b>： " + message);
                } else {
                    item.sendMessage("<b>" + user + "</b>: " + message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        ChatWebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        ChatWebSocketServer.onlineCount--;
    }
}
