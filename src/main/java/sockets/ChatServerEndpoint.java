package main.java.sockets;


import main.java.chat.ChatMessage;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/chat", encoders = {ChatMessage.MessageEncoder.class}, decoders = {ChatMessage.MessageDecoder.class})
public class ChatServerEndpoint {
    private static final Set<Session> sessions = Collections
            .synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(ChatMessage message, Session client)
            throws IOException, EncodeException {
        for (Session session : sessions) {
            session.getBasicRemote().sendObject(message);
        }
    }
}