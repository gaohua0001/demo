package com.dvt.core.proxool;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.logicalcobwebs.proxool.ConnectionPoolDefinitionIF;
import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.ProxoolFacade;
import org.logicalcobwebs.proxool.ProxoolListenerIF;

public class MyProxoolListenerIF implements ProxoolListenerIF {
	
	private static final Log log = LogFactory.getLog(MyProxoolListenerIF.class);
	MyProxoolConnectionListener lsnt = new MyProxoolConnectionListener();
	
	private static Map<String, String> aliasMap = new HashMap<String, String>();

	@Override
	public void onRegistration(
			ConnectionPoolDefinitionIF connectionPoolDefinition,
			Properties completeInfo) {
		String alias = connectionPoolDefinition.getAlias();
		log.info("注册proxool连接池 " + alias);
		if(!aliasMap.containsKey(alias)) {
			try {
				ProxoolFacade.addConnectionListener(alias, lsnt);
			} catch (ProxoolException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	@Override
	public void onShutdown(String alias) {
		// TODO Auto-generated method stub
		
	}

}
