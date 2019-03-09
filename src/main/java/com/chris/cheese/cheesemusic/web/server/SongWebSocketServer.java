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

@ServerEndpoint(value = "/songSocket/{user}")
@Component
public class SongWebSocketServer {
    private static int onlineCount = 1000000;

    private static CopyOnWriteArraySet<SongWebSocketServer> webSocketServers = new CopyOnWriteArraySet<>();

    private Session session;

    public Session getSession() {
        return session;
    }

    private String user = "";

    @OnOpen
    public void OnOpen(Session session, @PathParam("user") String user) {
        this.session = session;
        webSocketServers.add(this);
        addOnlineCount();
        this.user = user;
    }

    @OnClose
    public void onClose() {
        webSocketServers.remove(this);
        subOnlineCount();
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        webSocketServers.forEach(item -> {
            try {
                if (!item.getSession().equals(session)) {
                    item.sendMessage(message);
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
        SongWebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        SongWebSocketServer.onlineCount--;
    }
}
