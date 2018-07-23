package com.xujun.nio;

import java.util.logging.Logger;

/**
 * todo creater xujun creatTime 2016年12月1日
 */
public class Client {

	protected Logger logger = Logger.getLogger(this.getClass().getName());

	private static String DEFAULT_HOST = "127.0.0.1";

	private static int DEFAULT_PORT = 12345;

	private static ClientHandle clientHandle;

	public static void start() {
		start(DEFAULT_HOST, DEFAULT_PORT);
	}

	private static void start(String host, int port) {
		if (clientHandle != null) {
			clientHandle.stop();
		}
		clientHandle = new ClientHandle(host, port);
		new Thread(clientHandle, "Client").start();
	}

	// 向服务器发送消息
	public static boolean sendMsg(String msg) throws Exception {
		if (msg.equals("q")) {
			return false;
		}
		clientHandle.sendMsg(msg);
		return true;
	}

	public static void main(String[] args) {
		start();
	}
}
