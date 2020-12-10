package com.alibaba.dubbo.demo.provider;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	public static void main(String[] args) throws IOException {

		ApplicationContext context = new ClassPathXmlApplicationContext("/SystemRootContext.xml");
		((Lifecycle)context).start();
		System.in.read();
	}

}
