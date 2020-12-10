package com.dvt.snjs.util;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dvt.core.proxool.ProxoolUtil;
import com.dvt.core.spring.MyApplicationListener;

public class JscppUtil {
	
	private static Log log = LogFactory.getLog(JscppUtil.class);
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String alias, Class<T> clazz) {
		return (T) MyApplicationListener.getBean(alias);
	}
	
	public static void loadConfig(String springConfigFile) throws IOException, URISyntaxException {
		//URI uri = JscppUtil.class.getResource("/log-log4j2.xml").toURI();
		//org.apache.logging.log4j.core.LoggerContext.getContext().setConfigLocation(uri);
		loadSpringConfig(springConfigFile);
	}

	private static void loadSpringConfig(String springConfigFile) throws IOException {
		log.info("加载spring配置文件");
		ProxoolUtil.init();
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfigFile);
		((Lifecycle)context).start();
	}
	
	public static void stopSpring() {
		MyApplicationListener.stopSpring();
	}
	
	
	///
	///
	///
}
