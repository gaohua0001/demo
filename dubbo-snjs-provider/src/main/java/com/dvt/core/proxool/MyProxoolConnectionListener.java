package com.dvt.core.proxool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.logicalcobwebs.proxool.ConnectionListenerIF;

public class MyProxoolConnectionListener implements ConnectionListenerIF {
	
	private static Log log = LogFactory.getLog(MyProxoolConnectionListener.class);
	

	@Override
	public void onBirth(Connection connection) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDeath(Connection connection, int reasonCode)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void onExecute(String command, long elapsedTime) {
		if(elapsedTime > 3000) {
			command = command.replaceAll("\t", " ").replaceAll("\r", " ").replaceAll("\n", " ");
			log.debug("time(ms)=" + elapsedTime + ";command=" + command);
		}
	}

	@Override
	public void onFail(String command, Exception exception) {
		command = command.replaceAll("\t", " ").replaceAll("\r", " ").replaceAll("\n", " ");
		log.error(command);
		log.error(exception.getMessage(), exception);
	}

}
