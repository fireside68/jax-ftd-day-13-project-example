package com.cooksys.ftd.celebrity.news.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cooksys.ftd.celebrity.news.dao.ActorDao;
import com.cooksys.ftd.celebrity.news.dao.UserActorDao;
import com.cooksys.ftd.celebrity.news.dao.UserDao;

public class Server implements Runnable {
	
	private Logger log = LoggerFactory.getLogger(Server.class);
	
	private ExecutorService executor;
	private ServerSocket serverSocket;

	private ActorDao actorDao;
	private UserActorDao userActorDao;
	private UserDao userDao;

	@Override
	public void run() {
		try {
			while (true) {
				Socket socket = this.serverSocket.accept();
				ClientHandler handler = this.createClientHandler(socket);
				this.executor.execute(handler);
			}
		} catch (IOException e) {
			log.error("You have reached a server socket that has been disconnected or is no longer in service.", e);
		}

	}

	public ClientHandler createClientHandler(Socket socket) throws IOException {

		ClientHandler handler = new ClientHandler();

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		handler.setReader(reader);
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		handler.setWriter(writer);

		handler.setActorDao(actorDao);
		handler.setUserDao(userDao);
		handler.setUserActorDao(userActorDao);

		return handler;

	}

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public ActorDao getActorDao() {
		return actorDao;
	}

	public void setActorDao(ActorDao actorDao) {
		this.actorDao = actorDao;
	}

	public UserActorDao getUserActorDao() {
		return userActorDao;
	}

	public void setUserActorDao(UserActorDao userActorDao) {
		this.userActorDao = userActorDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
