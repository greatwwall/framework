package org.dubbo.consumer;

import org.dubbo.api.service.LoginService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xujun
 * @date 2018年9月4日 下午4:01:25
 */
public class Consumer {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		context.start();
		System.out.println("comsumer start.");
		LoginService loginService = context.getBean(LoginService.class);
		System.out.println("comsumer");
		System.out.println(loginService.getPremissions(2L));
		System.out.println(loginService.validate("admin login"));
	}
}
