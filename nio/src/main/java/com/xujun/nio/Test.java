package com.xujun.nio;

import java.util.Scanner;

/**
 * todo creater xujun creatTime 2016年12月1日
 */
public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		// 运行服务器
		Server.start();
		// 避免客户端先于服务端开启
		Thread.sleep(1000);
		// 运行客户端
		Client.start();
		while (Client.sendMsg(new Scanner(System.in).nextLine()))
			;
	}
}
