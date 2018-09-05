package org.dubbo.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xujun
 * @date 2018年9月4日 下午2:27:39
 */
public class Provider {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
		System.out.println(context.getDisplayName() + " : here.");
		context.start();
		System.out.println("service has been started.");
		System.in.read();
	}
}
