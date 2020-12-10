package com.dvt.core.proxool;

import org.logicalcobwebs.proxool.ProxoolFacade;

public class ProxoolUtil {

	public static void init() {
		ProxoolFacade.addProxoolListener(new MyProxoolListenerIF());
	}
}
