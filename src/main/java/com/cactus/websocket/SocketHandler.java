package com.cactus.websocket;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SocketHandler extends TextWebSocketHandler {
	private static final Logger logger = LogManager.getLogger(SocketHandler.class);
	@Autowired
	private ObjectMapper objectMapper;
	List<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		TextMessage message = new TextMessage("hello");
		session.sendMessage(message);
		sessions.add(session);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		for (WebSocketSession webSocketSession : sessions) {
			logger.debug("message: " + message);
			Map value = objectMapper.readValue(message.getPayload(), Map.class);
			logger.debug("session message:" + objectMapper.writeValueAsString(value));
			webSocketSession.sendMessage(new TextMessage("Hello " + value.get("name") + " !"));
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		session.close(CloseStatus.SERVER_ERROR);
	}

}
