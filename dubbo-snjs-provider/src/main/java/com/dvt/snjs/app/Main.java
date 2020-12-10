package com.dvt.snjs.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dvt.snjs.util.JscppUtil;

/**
 * 服务端
 * @author zane
 *
 */
public class Main {
	
	private static Log log = LogFactory.getLog(Main.class);

	public static void main(String[] args) {
		log.info("程序启动");
		try {
			JscppUtil.loadConfig("/SystemRootContext.xml");
		} catch (Throwable e) {
			log.error("配置文件加载失败了");
			log.error(e.getMessage(), e);
			System.exit(-1);
		}
		
		while(true) {
			log.info("程序运行中");
			try {
				Thread.sleep(10*60*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
