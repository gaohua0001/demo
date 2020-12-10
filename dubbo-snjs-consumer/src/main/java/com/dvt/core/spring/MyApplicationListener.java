package com.dvt.core.spring;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.logicalcobwebs.proxool.ProxoolFacade;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.Lifecycle;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
	
	private static final Log log = LogFactory.getLog(MyApplicationListener.class);
	
	public static ApplicationContext context = null;
	
	private boolean load = false;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		log.info(event);
		if(event instanceof ContextStartedEvent) {
			if(!load) {
				loadLog4jConfig();
				loadProxoolConfig();
				load = true;
			}
			context = ((ContextStartedEvent) event).getApplicationContext();
			log.info("context=" + context);
		} else if(event instanceof ContextRefreshedEvent) {
			//spring启动完成后加载proxool监听
			if(!load) {
				loadLog4jConfig();
				loadProxoolConfig();
				load = true;
			}
			context = ((ContextRefreshedEvent) event).getApplicationContext();
			log.info("context=" + context);
		} else if(event instanceof ContextClosedEvent) {
			ProxoolFacade.shutdown();
		} else if(event instanceof ContextStoppedEvent) {
			//关闭连接池
			ProxoolFacade.shutdown();
		} else {
		}
	}
	
	/**
	 * 加载log4j
	 */
	private static void loadLog4jConfig() {
		//PropertyConfigurator.configure(MyApplicationListener.class.getResource("/log4j.properties"));
	}
	
	/**
	 * 加载连接池
	 */
	private static void loadProxoolConfig() {
		//ProxoolFacade.disableShutdownHook();
		log.info("加载数据库连接池");
		//ProxoolUtil.init();
		//加载proxool连接池
		try {
			InputStream is = MyApplicationListener.class.getResourceAsStream("/proxool.xml");
			Reader reader = new InputStreamReader(is);
			JAXPConfigurator.configure(reader, false);
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver").newInstance();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			System.exit(-1);
		}
	}
	
	public static Object getBean(String alias) {
		return context.getBean(alias);
	}
	
	public static void stopSpring() {
		if(context != null) {
			((Lifecycle)context).stop();
		}
	}

}
