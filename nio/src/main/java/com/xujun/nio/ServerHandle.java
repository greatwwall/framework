package com.xujun.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

/**
 * todo creater xujun creatTime 2016年12月1日
 */
public class ServerHandle implements Runnable {

	protected Logger logger = Logger.getLogger(this.getClass().getName());

	private Selector selector;

	private ServerSocketChannel serverChannel;

	private volatile boolean started;

	public ServerHandle(int port) {
		try {
			// 创建选择器
			selector = Selector.open();
			// 打开监听通道
			serverChannel = ServerSocketChannel.open();
			// 开启非阻塞模式
			serverChannel.configureBlocking(false);
			// 绑定端口
			serverChannel.bind(new InetSocketAddress(port), 1024);
			// 监听客户端连接请求
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			// 标记服务已开启
			started = true;
			System.out.println("服务器已启动，端口号 ： " + port);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			System.exit(1);
		}
	}

	public void stop() {
		started = false;
	}

	@Override
	public void run() {
		// 循环遍历selector
		while (started) {
			try {
				// 无论是否有读写事件发生，selector每隔1s被唤醒一次
				selector.select(1000);
				//
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = keys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
		}
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleInput(SelectionKey key) throws IOException {
		if (key.isValid()) {
			// 处理新接入的请求消息
			if (key.isAcceptable()) {
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				// 通过ServerSocketChannel的accept创建SocketChannel实例
				// 完成该操作意味着TCP三次握手，TCP物理链路正式建立
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				// 注册为读
				sc.register(selector, SelectionKey.OP_READ);
			}
			// 读消息
			if (key.isReadable()) {
				SocketChannel sc = (SocketChannel) key.channel();
				// 创建bytebuffer，开辟一个1M的缓冲区空间
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				// 获取码流，返回字节数
				int readBytes = sc.read(buffer);
				if (readBytes > 0) {
					// 将缓冲区当前位置设置为position=0
					// 复位
					buffer.flip();
					// 根据缓冲区可读字节数创建字节数组
					byte[] bytes = new byte[buffer.remaining()];
					// 将可读字节数组复制到新建数组
					buffer.get(bytes);
					String expression = new String(bytes, "UTF-8");
					System.out.println("服务器收到的消息 : " + expression);
					// 服务端加工
					String result = expression + " accepted";
					doWrite(sc, result);
				} else {
					key.cancel();
					sc.close();
				}
			}
		}
	}

	// 异步发送应答消息
	private void doWrite(SocketChannel sc, String expression)
			throws IOException {
		// 将消息编码为字节数组
		byte[] bytes = expression.getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
		// 将字节数组复制缓冲区
		writeBuffer.put(bytes);
		// positon=0，复位
		writeBuffer.flip();
		// 发送缓冲区的字节数组
		sc.write(writeBuffer);
	}

}
