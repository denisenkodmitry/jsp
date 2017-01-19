package main.java.chat;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.websocket.*;
import java.io.StringReader;
import java.util.Collections;

public class ChatMessage {
    private String username;
    private String message;

    public ChatMessage() {
    }
    public ChatMessage(String username, String message) {
        super();
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class MessageEncoder implements Encoder.Text<ChatMessage> {
        public String encode(ChatMessage chatMessage) throws EncodeException {
            return Json.createObjectBuilder()
                    .add("username", chatMessage.getUsername())
                    .add("message", chatMessage.getMessage()).build().toString();
        }

        public void init(EndpointConfig endpointConfig) {

        }

        public void destroy() {

        }
    }

    public static class MessageDecoder implements Decoder.Text<ChatMessage> {
        private JsonReaderFactory factory = Json
                .createReaderFactory(Collections.<String, Object>emptyMap());

        public ChatMessage decode(String s) throws DecodeException {
            ChatMessage message = new ChatMessage();
            JsonReader reader = factory.createReader(new StringReader(s));
            JsonObject json = reader.readObject();
            message.setUsername(json.getString("username"));
            message.setMessage(json.getString("message"));
            return message;
        }

        public boolean willDecode(String s) {
            return true;
        }

        public void init(EndpointConfig endpointConfig) {

        }

        public void destroy() {

        }
    }
}